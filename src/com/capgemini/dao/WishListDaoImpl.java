package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;

public class WishListDaoImpl implements WishListDao {
private Map<String, WishListDto> map;
private Logger logger = Logger.getLogger(WishListDao.class);
	
	public WishListDaoImpl()
	{
		map=new HashMap<String,WishListDto>();
	}
	public String addProductToWishList(WishListDto product) throws WishListException {
		boolean flag = map.containsKey(product.getProductName());
		logger.info("Product added :"+product.getProductName());
		if(flag)
		{
			throw new WishListException("Product already Exist");
		}
		map.put(product.getProductName(), product);
		return product.getProductName();
	}
	public List<WishListDto> findAllProductsInWishList() throws WishListException {
		Collection<WishListDto> col = map.values();
		List<WishListDto> list = new ArrayList<>();
		
		for(WishListDto w : col)
		{
			list.add(w);
		}
		return list;
	}

}
