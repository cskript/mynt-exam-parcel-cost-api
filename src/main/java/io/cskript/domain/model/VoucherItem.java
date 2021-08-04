package io.cskript.domain.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VoucherItem {

	private String code;
	private BigDecimal discount;
	private String expiry;
	public VoucherItem() {}
	public VoucherItem(String code, BigDecimal discount, String expiry) {
		this.code = code;
		this.discount = discount;
		this.expiry = expiry;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VoucherItem [code=").append(code).append(", discount=").append(discount).append(", expiry=")
				.append(expiry).append("]");
		return builder.toString();
	}
}
