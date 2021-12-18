package com.insurance.model;

import java.io.Serializable;



import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Policy implements Serializable {
	@Id
	private int policyId;
	@NotBlank(message = "policyName should not be not empty")
	private String policyName;
	@NotBlank(message = "policyType should not be not empty")
	private String policyType;
	@NotNull(message = "policyCoverageYear should not be not empty")
	private int policyCoverageYear;
	@NotNull(message = "policyCoverageAmount should not be not empty")
	private int policyCoverageAmount;
	@Past
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date policyStartDate;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date policyEndDate;
	@OneToMany
	private List<Agent> agent;
}
