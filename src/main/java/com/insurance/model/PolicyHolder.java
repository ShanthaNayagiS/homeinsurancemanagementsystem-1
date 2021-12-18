package com.insurance.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PolicyHolder implements Serializable {
	@Id
	@GeneratedValue
	private int policyHolderId;
	@NotBlank(message = "policyHolderName should not be not empty")
	private String policyHolderName;
	@NotNull(message = "not empty")
	private Integer userId;
	@NotNull(message = "not empty")
	private Integer assetId;
//	@NotNull(message = "not empty")
//	private Integer policyId;
//	@OneToOne
//	@JoinColumn(name="joined_policy_id")
//	private Policy policy;
//	@ManyToOne
//	@JoinColumn(name="agent_id")
//	private Agent agent;
}

