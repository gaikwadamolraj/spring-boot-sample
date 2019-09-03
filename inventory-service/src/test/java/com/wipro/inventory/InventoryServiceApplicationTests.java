package com.wipro.inventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InventoryServiceApplicationTests {
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void test01ContextLoads() {
		assertNotNull("rest template not avialble", restTemplate);
	}
	
	@Test
	public void test02GetSKUs() {
		ResponseEntity<List> res = restTemplate.getForEntity("/skus", List.class);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(0, res.getBody().size());
	}
	
	@Test
	public void test03AddSKU() {
		SKU sku = new SKU();
		sku.setName("one");
		sku.setCount(5);
		sku.setPrice(1.5);
		sku.setProductID(1);
		ResponseEntity<?> res = restTemplate.postForEntity("/skus", sku, SKU.class);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());		
	}
	
	@Test
	public void test04GetSKUs() {
		ResponseEntity<List> res = restTemplate.getForEntity("/skus", List.class);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}
	

}
