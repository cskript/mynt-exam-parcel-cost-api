package io.cskript.model;

import java.math.BigDecimal;

public class ParcelRule implements Comparable<ParcelRule> {
	
	enum Condition {
		EXCEED, LESS
	}
	private int priority;
	private String name;
	private BigDecimal weightMin;
	private BigDecimal weightMax;
	private BigDecimal volume;
	private Condition condition;
	private BigDecimal cost;
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getWeightMin() {
		return weightMin;
	}
	public void setWeightMin(BigDecimal weightMin) {
		this.weightMin = weightMin;
	}
	public BigDecimal getWeightMax() {
		return weightMax;
	}
	public void setWeightMax(BigDecimal weightMax) {
		this.weightMax = weightMax;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	@Override
	public int compareTo(ParcelRule o) {
		return Integer.compare(this.getPriority(), o.getPriority());
	}
	
}
