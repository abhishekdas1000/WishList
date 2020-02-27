package com.capgemini.service;

import java.util.List;

import com.capgemini.dao.WishListDao;
import com.capgemini.dao.WishListDaoImpl;
import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;

public class WishListServiceImpl implements WishListService {
private WishListDao wlDao;
	
	public WishListServiceImpl()
	{
		wlDao = new WishListDaoImpl();
	}

public String addProductToWishList(WishListDto product) throws WishListException {
	String pName = product.getProductName();
	pName=wlDao.addProductToWishList(product);
	return pName;
}

public List<WishListDto> findAllProductsInWishList() throws WishListException {
	return wlDao.findAllProductsInWishList();
}

}
