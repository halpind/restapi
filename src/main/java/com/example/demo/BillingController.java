package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@PostMapping("/{countryCode}/{productCode}")
	public String billCustomer(@PathVariable String countryCode, @PathVariable String productCode,
			@RequestBody BillingRequest billingRequest) {
		System.out.println(String.format("Request for country [%s] product [%s]", countryCode, productCode));
		String customer = billingRequest.getFirstname() + " " + billingRequest.getSurname();
		return String.format("Got billing request for amount of %.2f for customer %s located in %s email address[%s]",
				billingRequest.getAmount(), customer, billingRequest.getCountry(), billingRequest.getEmail());
	}

	@GetMapping
	public String getInfo() {
		return "Hello";
	}
}
