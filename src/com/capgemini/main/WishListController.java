package com.capgemini.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.dto.WishListDto;
import com.capgemini.exception.WishListException;
import com.capgemini.service.WishListService;
import com.capgemini.service.WishListServiceImpl;

public class WishListController {
	public WishListController() {
		Scanner sc = new Scanner(System.in);
	    WishListService wlService = new WishListServiceImpl();
		
		int choice = 0;
		WishListDto wl = null;
		List<WishListDto> list = null;
		while(true)
		{
			System.out.println("1.Add product to wishlist");
			System.out.println("2.View Wishlist");
			System.out.println("3.Exit");
			System.out.println("enter your choice");
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("please enter a number nothing else");
				sc.nextLine();
			}
			switch(choice)
			{
			case 1:
				System.out.print("Enter Product Name : ");
			    String prod = sc.next();
				wl = new WishListDto();
				wl.setProductName(prod);
				try
				{
				String pName = wlService.addProductToWishList(wl);
				System.out.println("Product = "+pName+ " succesfully added to wishlist");
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
				System.exit(0);
			default:
				System.err.println("Invalid input!! Please enter number between 1 to 3 only!");
				break;
			}
		}
	}
	public static void main(String[] args) 
	{
		new WishListController();
	}
}