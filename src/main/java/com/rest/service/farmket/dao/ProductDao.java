package com.rest.service.farmket.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.service.farmket.model.ProductSheet;

@Repository
public interface ProductDao extends CrudRepository<ProductSheet, Long>{
	List<ProductSheet> findByFarmerId(Long id);
	List<ProductSheet> findByMarketId(Long id);
 } 
