package com.rest.service.farmket.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.service.farmket.model.ProductSheet;

@Repository
public interface ProductDao extends CrudRepository<ProductSheet, Integer>{
	
}
