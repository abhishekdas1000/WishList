package com.capgemini.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;
import com.capgemini.service.Validator;
import com.capgemini.service.WishListService;
import com.capgemini.service.WishListServiceImpl;

public class WishListController {
	
	public WishListController(){
		Scanner sc = new Scanner(System.in);
	    WishListService wlService = new WishListServiceImpl();
		Validator v=new Validator();
		int choice = 0;
		WishListDto wl = null;
		List<WishListDto> list = null;
		while(true)
		{
			System.out.println("1.Add product to wishlist");
			System.out.println("2.View Wishlist");
			System.out.println("3.Exit");
			System.out.println("enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.print("Enter Product Name : ");
				System.out.println("\n Note: Product name should not be blank and first letter should be capital");
			    String prod = sc.next();
				wl = new WishListDto();
				wl.setProductName(prod);
				try
				{
					if(v.validateProductName(prod)) {
				String pName = wlService.addProductToWishList(wl);
				System.out.println("Product = "+pName+ " succesfully added to wishlist");
				}
					else {
						System.out.println("please enter valid Product name");
					}
				}
				catch(WishListException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				try
				{
					list = wlService.findAllProductsInWishList();
					for(WishListDto w : list)
						System.out.println("Product name = "+w.getProductName());
				}
				catch(WishListException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Exiting WishList.........");
				return;
			default:
				System.err.println("Incorrect choice");
				System.err.println("enter correct choice");
				break;
			}
		}

	}
	public static void main(String[] args) 
	{
		new WishListController();
			}
}
