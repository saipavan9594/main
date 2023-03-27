package com.example.section4accounts.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.section4accounts.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
