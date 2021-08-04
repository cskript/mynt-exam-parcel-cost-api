package io.cskript.service;

import java.math.BigDecimal;

import io.cskript.domain.model.VoucherItem;
import io.cskript.model.Parcel;
import io.cskript.model.ParcelRequest;

public interface MyntService {

	public Parcel getEvaluatedParcel(ParcelRequest parcelRequest) throws ServiceException, ValidationException;
	
	public Parcel getEvaluatedParcel(BigDecimal weight, BigDecimal width, BigDecimal length, String voucherCode) throws ServiceException, ValidationException;
	
	public VoucherItem getVoucherItem(String voucherCode) throws ServiceException;
}
