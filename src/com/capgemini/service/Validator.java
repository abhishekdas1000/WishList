package com.capgemini.service;

public class Validator {

	public Validator() {
		//Constructor
	}
	public boolean validateProductName(String pName) {
		if(!pName.matches("[A-Z][a-z,A-Z,0-9,\\s]")) {
			System.out.println("\n Note: Product name should not be blank and first letter should be capital");
					return false;
		}
		else {
			System.out.println("\n Product name is already there in the list");
			return true;
		}
	}
}
