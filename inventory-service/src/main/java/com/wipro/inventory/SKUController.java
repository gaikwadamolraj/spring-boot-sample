package com.wipro.inventory;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping ("/skus")
	public List<SKU> getSKUs() {
		return skus;
	}
	
	@PostMapping("/skus")
	public ResponseEntity<SKUResponse> addSKU(@RequestBody SKU newSku) {
		newSku.setId(ID.incrementAndGet());
		skus.add(newSku);
		
		if(null == newSku.getProductID()) {
			SKUResponse response = new SKUResponse("Bad Reqeust",null, "productId should not be null");
			return new ResponseEntity<> (response, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<> (new SKUResponse("Created", "Created new product", null), HttpStatus.CREATED);
	}

}
