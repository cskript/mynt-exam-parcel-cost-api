package io.cskript.domain.adapter;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.cskript.domain.model.VoucherItem;

@Component
public class MyntAdapter {

	@Value("#{@environment.getProperty('service.common.host.mynt')}")
	private String host;
	@Value("${service.mynt.key}")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate;

	public MyntAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public VoucherItem getVoucherItem(String voudcherCode) throws AdapterException {
		if (!StringUtils.hasText(voudcherCode)) 
			return new VoucherItem();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

		String url = new StringBuilder(host).append("/voucher/").append(voudcherCode).append("?key=").append(apiKey).toString();
		
		try {
			return restTemplate.exchange(url, HttpMethod.GET, entity, VoucherItem.class).getBody();
		} catch (RestClientException e) {
			throw new AdapterException(e.getMessage(), e);
		}
	}

}
