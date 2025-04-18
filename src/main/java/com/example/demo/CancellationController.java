package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cancel")
public class CancellationController {

	@PostMapping("/{countryCode}/{productCode}")
	public String cancelCustomerPolicy(@PathVariable String countryCode, @PathVariable String productCode,
			@RequestBody CancelRequest cancelRequest) {
		System.out.println(String.format("Request for country [%s] product [%s]", countryCode, productCode));
		String customer = cancelRequest.getFirstname() + " " + cancelRequest.getSurname();
		return String.format("Got cancel request for customer %s located in %s email address[%s]", customer,
				cancelRequest.getCountry(), cancelRequest.getEmail());
	}
}
