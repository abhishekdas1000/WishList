package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;

public interface WishListService {
	public String addProductToWishList(WishListDto product) throws WishListException;
	public List<WishListDto> findAllProductsInWishList() throws WishListException;
}
