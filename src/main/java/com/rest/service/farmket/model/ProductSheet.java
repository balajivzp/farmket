package com.rest.service.farmket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductSheet {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer prodId;
	private Integer farmerId;
	private Integer marketId;
	private String  productName;
	private String  date;
	private Integer productQuantity;
	private String  status;
	
	protected ProductSheet() {
		
	}
	
	public ProductSheet(Integer prodId, Integer farmerId, Integer marketId, String productName, String date,
			Integer productQuantity, String status) {
		super();
		this.prodId = prodId;
		this.farmerId = farmerId;
		this.marketId = marketId;
		this.productName = productName;
		this.date = date;
		this.productQuantity = productQuantity;
		this.status = status;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
