package com.capgemini.dao;

import java.util.List;

import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;

public interface WishListDao {
	public String addProductToWishList(WishListDto product) throws WishListException;
	public List<WishListDto> findAllProductsInWishList() throws WishListException;
}
