package com.jumia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSearchRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String country;
	private Boolean valid;
}
