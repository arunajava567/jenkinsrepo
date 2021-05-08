package com.cg;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.model.Product;

class ProductClient {
@Autowired
RestTemplate restTemplate;
public void getProductDetails() {
	
  final String uri = "http://localhost:8083/api/v1/products/"+1003;
RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
HttpEntity <String> entity = new HttpEntity<String>(headers);


 ResponseEntity<Product> response = restTemplate.getForEntity(uri, Product.class);

Product p=new Product(1023,"bag",89, 987.89,new Date());
//HttpEntity <Product> entity1 = new HttpEntity<Product>(headers);

System.out.println(response.getBody().toString());

System.out.println(restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody().toString());
restTemplate.exchange("http://localhost:8083/api/v1/products/"+1002, HttpMethod.DELETE, entity, String.class).getBody();
//restTemplate.exchange("http://localhost:8083/api/v1/products", HttpMethod.POST, entity1, Product.class).getBody();
}
public static void main(String[] args) {
	ProductClient client= new ProductClient();
	client.getProductDetails();
}
}



 //restTemplate.exchange("http://localhost:8085/booking/", HttpMethod.POST, entity, String.class).getBody();
//restTemplate.exchange("http://localhost:8085/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
