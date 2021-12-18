package com.insurance.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PolicyPayment implements Serializable {
	@Id
	@GeneratedValue
	private int policyPaymentId;
	@NotNull(message = "not empty")
	private Integer userId;
	@NotNull(message = "not empty")
//    private Integer policyId;
//    @NotNull(message = "not empty")
	private Integer policyPaymentAmount;
	@NotNull(message = "not empty")
	private Integer policyPaymentbankAccNo;
//
//	@OneToMany
//	@JoinColumn(name = "Policy_id")
//	private List<Policy> policy;
//	@OneToMany
//	@JoinColumn(name = "userEntry_id")
//	private List<UserEntry> userEntry;

}
