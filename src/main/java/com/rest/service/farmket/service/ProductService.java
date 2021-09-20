package com.rest.service.farmket.service;

import java.util.List;
import java.util.Map;

import com.rest.service.farmket.model.ProductSheet;

public interface ProductService {
	String save(ProductSheet productSheet);
	ProductSheet getProductDetail(Long id);
	
}
