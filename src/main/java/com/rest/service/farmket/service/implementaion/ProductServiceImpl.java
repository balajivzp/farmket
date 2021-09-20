package com.rest.service.farmket.service.implementaion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.service.farmket.dao.ProductDao;
import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.service.ProductService;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public String save(ProductSheet productSheet) {
		productDao.save(productSheet);
		return "productSheet updated";
		
	}
	
	@Override
	public ProductSheet getProductDetail(Long id)  {
		Optional<ProductSheet> optional= productDao.findById(id);
		ProductSheet productSheet = null;
		if(optional.isPresent()) {
			 productSheet = optional.get();
			
		}
		return productSheet;
		
	}
	

}
