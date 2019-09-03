package com.wipro.inventory;

import lombok.Data;

@Data
public class SKU {
	private Integer productId;
	private String name;
	private Integer id;
	private String description;
	private Double price;
	private Integer count;
}
