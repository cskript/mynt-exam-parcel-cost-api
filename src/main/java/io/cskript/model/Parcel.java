package io.cskript.model;

import java.math.BigDecimal;

public class Parcel {

	private ParcelRequest parcelRequest;
	private BigDecimal volume;
	private String type;
	private BigDecimal rate;
	private BigDecimal cost;
	public ParcelRequest getParcelRequest() {
		return parcelRequest;
	}
	public void setParcelRequest(ParcelRequest parcelRequest) {
		this.parcelRequest = parcelRequest;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
