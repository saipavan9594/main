package com.example.section4accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.section4accounts.config.AccountsServiceConfig;
import com.example.section4accounts.model.Accounts;
import com.example.section4accounts.model.Customer;
import com.example.section4accounts.model.Properties;
import com.example.section4accounts.repository.AccountsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	AccountsServiceConfig accountsConfig;
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId());
		if(accounts!=null) {
			return accounts;
		}
		else
			return null;
	}
	
	@GetMapping(path="/accounts/properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}

}
