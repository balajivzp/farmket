package com.rest.service.farmket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/productsheet")
public class ProductSheetController {
	
	 @Autowired
	 private ProductService productService;
	 
	 @RequestMapping(value = "/saveProductSheet", method = RequestMethod.POST)
	    public String saveProductSheet(@RequestBody ProductSheet productSheet) {
	    	return productService.save(productSheet);
	    }
	 
	 @RequestMapping(value = "/getProductDetail/{id}")
	 public ProductSheet getMarketDetail(@PathVariable Long id) {
		 return productService.getProductDetail(id);
	 }
}
