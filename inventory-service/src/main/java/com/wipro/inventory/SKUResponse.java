package com.wipro.inventory;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SKUResponse {

	@JsonProperty("Status")
    private String status;

	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Error")
	private String error;	
}