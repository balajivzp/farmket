package com.rest.service.farmket.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.service.farmket.model.Wallet;

@Repository
public interface WalletDao  extends CrudRepository<Wallet, Long>{
	Wallet findByFarmerId(Long id);

}
