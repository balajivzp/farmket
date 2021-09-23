package com.rest.service.farmket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.model.Wallet;
import com.rest.service.farmket.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/productsheet")
public class ProductSheetController {
	
	 @Autowired
	 private ProductService productService;
	 
	 @RequestMapping(value = "/saveProductSheet", method = RequestMethod.POST)
	    public Map<String, String> saveProductSheet(@RequestBody ProductSheet productSheet) {
	    	String message =  productService.save(productSheet);
	    	Map<String, String> map = new HashMap<>();
	    	map.put("message", message);
	    	return map;
	    }
	 
	 @RequestMapping(value = "/getProductDetail/{id}", method = RequestMethod.GET)
	 public List<ProductSheet> getMarketDetail(@PathVariable Long id) {
		 return productService.getProductDetails(id);
	 }
	 @RequestMapping(value = "/getProductDetailByMarketId/{id}", method = RequestMethod.GET)
	 public List<ProductSheet> getMarketDetailbyMarketId(@PathVariable Long id) {
		 return productService.getProductDetailsByMarket(id);
	 }
	 
	 @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	 public Map<String , String> deleteProduct(@PathVariable Long id) {
		 String message = productService.deleteProduct(id);
		 Map<String , String> map = new HashMap<>();
		 map.put("message", message);
		 return map;
	 }
	 @RequestMapping(value = "/getBalance/{id}", method = RequestMethod.GET)
	 public Wallet  getBalance(@PathVariable Long id) {
		 return productService.getBalance(id);
		
	 }
	 @RequestMapping(value = "/saveBalance", method = RequestMethod.POST)
	 public Map<String, String> saveBalance(@RequestBody Wallet wallet) {
		 String message = productService.saveBalance(wallet);
		 Map<String , String> map = new HashMap<>();
		 map.put("message", message);
		 return map;
	 }
}
