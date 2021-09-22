package com.rest.service.farmket.service.implementaion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.service.farmket.dao.ProductDao;
import com.rest.service.farmket.dao.WalletDao;
import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.model.Wallet;
import com.rest.service.farmket.service.ProductService;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private WalletDao walletDao;

	@Override
	public String save(ProductSheet productSheet) {
		productDao.save(productSheet);
		return "productSheet updated";
		
	}
	
	
	@Override
	public String deleteProduct(Long id) {
		productDao.deleteById(id);
		return "Product Deleted Successfully";
	}


	@Override
	public List<ProductSheet> getProductDetails(Long id) {
		return productDao.findByFarmerId(id);
		
	}


	@Override
	public List<ProductSheet> getProductDetailsByMarket(Long id) {
		return productDao.findByMarketId(id);
	}


	@Override
	public Wallet getBalance(Long id) {
		return walletDao.findByFarmerId(id);
	}


	@Override
	public String saveBalance(Wallet wallet) {
		walletDao.save(wallet);
		return "Successfully Updated ";
	}


	

}
