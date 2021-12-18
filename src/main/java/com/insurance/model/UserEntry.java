package com.insurance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntry implements Serializable {
	@Id
	@GeneratedValue
	private int userId;
	@NotBlank(message = "UserName should not be not empty")
	private String userName;
	@Past
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date userDob;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String userEmail;
	@Column(unique = true)
	@Pattern(regexp = "[0-9]{10}")
	private String userPhone;
	@NotBlank(message = "userOccupation should not be not empty")
	private String userOccupation;
	@NotNull(message = "userAnnualIncome not empty")
	private Integer userAnnualIncome;
	@NotBlank(message = "userAddress should not be not empty")
	private String userAddress;
	@NotNull(message = "userPinCode not empty")
	private Integer userPinCode;
}
