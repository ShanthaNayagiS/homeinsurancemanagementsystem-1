package com.insurance.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AgentAllocation implements Serializable {
	@Id
	@GeneratedValue
	private int agentAllocationId;
	@NotNull(message = "not empty")
	private Integer userId;
	@NotNull(message = "not empty")
	private Integer userPinCode;
	@NotNull(message = "not empty")
	private Integer agentId;
	@NotNull(message = "not empty")
	private Integer agentPinCode;
	
//	@OneToMany(mappedBy="agent",cascade=CascadeType.ALL)
//	@JsonIgnore
//	private Set<UserEntry> UserEntryList=new HashSet<>();
}