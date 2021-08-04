package io.cskript.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import io.cskript.model.ParcelRule;

@Component
@ConfigurationProperties
public class Config {

	private List<ParcelRule> parcelRules;

	public void setParcelRules(List<ParcelRule> parcelRules) {
		this.parcelRules = parcelRules;
	}

	public List<ParcelRule> getParcelRules() {
		return this.parcelRules;
	}

	
}
