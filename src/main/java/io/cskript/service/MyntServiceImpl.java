package io.cskript.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.cskript.config.Config;
import io.cskript.domain.adapter.AdapterException;
import io.cskript.domain.adapter.MyntAdapter;
import io.cskript.domain.model.VoucherItem;
import io.cskript.model.Parcel;
import io.cskript.model.ParcelRequest;
import io.cskript.model.ParcelRule;

@Component
public class MyntServiceImpl implements MyntService {

	@Autowired
	private Config config;

	@Autowired
	private MyntAdapter myntAdapter;

	@Override
	public Parcel getEvaluatedParcel(BigDecimal weight, BigDecimal width, BigDecimal length, String voucherCode) throws ServiceException, ValidationException {
		return getEvaluatedParcel(new ParcelRequest(weight, weight, width, length, voucherCode));
	}

	public Parcel getEvaluatedParcel(ParcelRequest parcelRequest) throws ServiceException, ValidationException {
		Parcel parcel = new Parcel();
		if (parcelRequest != null) {
			validateRequiredParcelRequest(parcelRequest);
			
			parcel.setParcelRequest(parcelRequest);
			
			parcel.setVolume(parcelRequest.getHeight().multiply(parcelRequest.getWidth().multiply(parcelRequest.getLength())));

			List<ParcelRule> rules = config.getParcelRules();
			Collections.sort(rules);
			applySpecificParcelRule(rules, parcel);
			
			applyAndCheckForDiscount(parcel);
		}

		return parcel;
	}

	private void validateRequiredParcelRequest(ParcelRequest pr) throws ValidationException {
		if (pr.getWeight() == null || pr.getHeight() == null || pr.getWidth() == null || pr.getLength() == null) {
			throw new ValidationException("Missing required field and these are Weight, Height, Width, and Length.");
		}
	}
	
	private void applySpecificParcelRule(List<ParcelRule> parcelRules, Parcel parcel) {
		ParcelRule parcelRule = null;
		boolean isItBasedOnWeightRate = false;
		for (ParcelRule rule : parcelRules) {
			ParcelRequest parcelRequest = parcel.getParcelRequest();
			BigDecimal weight = parcelRequest.getWeight(), minWeight = rule.getWeightMin(), maxWeight = rule.getWeightMax();
			BigDecimal volume = parcel.getVolume(); 
			parcelRule = rule;
			
			if (minWeight!=null && weight.compareTo(minWeight) == 1) {
				isItBasedOnWeightRate = true;
				break;
			} else if (minWeight!=null && weight.compareTo(minWeight) == 1
					&& maxWeight!=null && weight.compareTo(maxWeight) == -1) {
				isItBasedOnWeightRate = true;
				break;
			} else if (rule.getVolume()!=null && volume.compareTo(rule.getVolume())==-1) {
				break;
			}
		}
		if (parcelRule!=null) {
			parcel.setType(parcelRule.getName());
			
			if (parcelRule.getCost() != null) {
				parcel.setRate(parcelRule.getCost());
				parcel.setCost(
						isItBasedOnWeightRate ? parcelRule.getCost().multiply(parcel.getParcelRequest().getWeight())
								: parcelRule.getCost().multiply(parcel.getVolume()));
			} else {
				parcel.setRate(new BigDecimal(0));
				parcel.setCost(new BigDecimal(0));
			}
		}
		
	}

	private void applyAndCheckForDiscount(Parcel parcel) throws ServiceException {
		String voucherCode = parcel.getParcelRequest().getVoucherCode();
		try {
			VoucherItem voucherItem = myntAdapter.getVoucherItem(voucherCode);
			if (voucherCode!=null) {
				LocalDate today = LocalDate.now();
				LocalDate expiry = LocalDate.parse(voucherItem.getExpiry());
				if (today.compareTo(expiry) == -1)
					parcel.setCost( parcel.getCost().subtract(voucherItem.getDiscount()) );
			}
		} catch (AdapterException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public VoucherItem getVoucherItem(String code) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
