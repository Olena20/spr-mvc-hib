package com.sprhib;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestService {
	
	
	  @Test(invocationCount = 30, threadPoolSize=5)
	  public void thatOrdersCanBeAddedAndQueried() {
		  
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    RestTemplate template = new RestTemplate();


	    ResponseEntity<ErrorMessage> incorrectEntity = template.getForEntity(
	    		"http://localhost:8080/spr-mvc-hib/convertation/-110/EUR/USD",
	    		ErrorMessage.class);

	    Assert.assertEquals("Money should be positive float number.", incorrectEntity.getBody().getErrorMessage());

	    template.getForEntity(
	    		"http://localhost:8080/spr-mvc-hib/convertation/0/EUR/USD",
	    		ErrorMessage.class);

	    Assert.assertEquals("Money should be positive float number.", incorrectEntity.getBody().getErrorMessage());

	    
	    incorrectEntity = template.getForEntity(
	    		"http://localhost:8080/spr-mvc-hib/convertation/110/EUR111/USD",
	    		ErrorMessage.class);
	    Assert.assertEquals("Incorrect currency code! EUR111", incorrectEntity.getBody().getErrorMessage());

	    ResponseEntity<String> entity = template.getForEntity(
	    		"http://localhost:8080/spr-mvc-hib/convertation/110/EUR/USD",
	    		String.class);
	    
	    Assert.assertEquals("84.7", entity.getBody());
	    

	  }
}
