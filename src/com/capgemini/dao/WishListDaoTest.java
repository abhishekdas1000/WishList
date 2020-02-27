package com.capgemini.dao;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;

public class WishListDaoTest {
	private static WishListDaoImpl wDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		wDao=new WishListDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddProductToWishList() {
		Map<String, WishListDto> map=wDao.getDao();
		assertNotNull(map);
	}

}
