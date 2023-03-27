package com.example.section4accounts.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Accounts {
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "account_number")
	@Id
	private long accountNumber;
	@Column(name = "account_type")
	private String accountType;
	@Column(name = "branch_address")
	private String branch;
	@Column(name = "create_dt")
	private LocalDate createdDate;

}
