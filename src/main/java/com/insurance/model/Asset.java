package com.insurance.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asset implements Serializable {
	@Id
	@GeneratedValue
	private int assetId;
	@NotBlank(message = "assetType should not be not empty")
	private String assetType;
	@NotNull(message = "assetArea not empty")
	private Integer assetArea;
	@NotNull(message = "assetValue not empty")
	private Integer assetValue;
}
