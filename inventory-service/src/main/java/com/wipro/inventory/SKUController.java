package com.wipro.inventory;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController 

public class SKUController {
	
	static AtomicInteger ID = new AtomicInteger();
	List<SKU> skus = new ArrayList<>();
	
	@GetMapping ("/skus/")
	public List<SKU> getSKUs() {
		return skus;
	}
	
	@PostMapping("/skus/")
	public ResponseEntity<?> addSKU(@RequestBody SKU newSku) {
		newSku.setId(ID.incrementAndGet());
		skus.add(newSku);
		
		if(null == newSku.getProductID()) {
			return new ResponseEntity<> ("productId should not be null", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<> ("Created new product", HttpStatus.CREATED);
	}
	

}
