package com.capgemini.dto;

public class WishListDto {
	private String productName;
	  
	  public WishListDto(String productName) {
		  super();
		  this.productName = productName;
	  }
	  public WishListDto(){
		  super();
	  }
	  public String getProductName() { 
		  return productName;
	  }
	  public void setProductName(String prod){
	       this.productName=prod;
	  }
}
