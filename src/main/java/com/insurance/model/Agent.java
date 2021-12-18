package com.insurance.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Agent implements Serializable {
	@Id
	@GeneratedValue
	private int agentId;
	@NotBlank(message = "policyName should not be not empty")
	private String agentName; 
	@NotBlank(message = "policyName should not be not empty")
	private String address;
	@NotNull(message = "agentPinCode not empty")
	private int agentPinCode;
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	@Column(unique=true)
	@Pattern(regexp="[0-9]{10}")
	private String mobileNo;
//	@OneToMany(mappedBy="agent",cascade=CascadeType.ALL)
//	@JsonIgnore
//	private List<PolicyHolder> policyHolders;
	@ManyToOne//(mappedBy="agent",cascade=CascadeType.ALL)
	@JsonIgnore
	private Policy policies;

}

