package io.cskript.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.cskript.model.Parcel;
import io.cskript.model.ParcelRequest;
import io.cskript.model.Status;
import io.cskript.service.MyntService;
import io.cskript.service.ServiceException;
import io.cskript.service.ValidationException;

@RestController
@RequestMapping("/api/v1/mynt")
public class MyntController {

	/*
	 * @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
	 */

	@Autowired
	private MyntService myntService;
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Status> handleException(ValidationException e) {
		return new ResponseEntity<Status>(new Status("400", "Inavlid Request", e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Status> handleException(ServiceException e) {
		return new ResponseEntity<Status>(new Status("500", "Service Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/weight/{weight}/height/{height}/width/{width}/length/{length}")
	public Parcel get(
			@PathVariable("weight") BigDecimal weight,
			@PathVariable("width") BigDecimal width,
			@PathVariable("length") BigDecimal length,
			@RequestParam(value="code", required=false) String voucherCode) throws ServiceException, ValidationException {
		return myntService.getEvaluatedParcel(weight, width, length, voucherCode);
	}
	
	@PostMapping
	public Parcel get(@RequestBody ParcelRequest parcelRequest) throws ServiceException, ValidationException {
		return myntService.getEvaluatedParcel(parcelRequest);
	}
}
