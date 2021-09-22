package com.rest.service.farmket.service;

import java.util.List;
import java.util.Map;

import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.model.Wallet;

public interface ProductService {
	String save(ProductSheet productSheet);
	List<ProductSheet> getProductDetails(Long id);
	List<ProductSheet> getProductDetailsByMarket(Long id);
	String deleteProduct(Long id);
	Wallet getBalance(Long id);
	String saveBalance(Wallet wallet);
}
