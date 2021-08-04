package io.cskript.model;

import java.math.BigDecimal;

public class ParcelRequest {

	private BigDecimal weight;
	private BigDecimal height;
	private BigDecimal width;
	private BigDecimal length;
	private String voucherCode;
	public ParcelRequest() {}
	public ParcelRequest(BigDecimal weight, BigDecimal height, BigDecimal width, BigDecimal length,
			String voucherCode) {
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
		this.voucherCode = voucherCode;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
}
