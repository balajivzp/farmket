package com.rest.service.farmket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductSheet {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long prodId;
	private Long farmerId;
	private Long marketId;
	private String  productName;
	private String  date;
	private Long quantity;
	private Boolean  isApproved;
	
	protected ProductSheet() {
		
	}

	public ProductSheet(Long prodId, Long farmerId, Long marketId, String productName, String date, Long quantity,
			Boolean isApproved) {
		super();
		this.prodId = prodId;
		this.farmerId = farmerId;
		this.marketId = marketId;
		this.productName = productName;
		this.date = date;
		this.quantity = quantity;
		this.isApproved = isApproved;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
	