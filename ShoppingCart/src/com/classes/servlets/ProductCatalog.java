package com.classes.servlets;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductCatalog {
		   ArrayList<Product> productList = new ArrayList<Product>();
		   
		   public ProductCatalog() { }
		   	
		    //Return the single Product object associated with the Product_ID
			public Product getProduct(int Prod_ID) 
			{
			    Iterator<Product> iProduct = productList.iterator();
			    while (iProduct.hasNext()) {
			      Product p = (Product) iProduct.next();
			      if (p.getId() == Prod_ID)
			    	  return p;
			    }
			    return null;
			} // end of getProduct()

		    //Updates the product information to the database
			public void updateProduct(Product p) 
			{
				Product prevProduct = getProduct(p.getId());
				int index = productList.indexOf(prevProduct);
				productList.remove(index);
		    	productList.add(index, p);
			} // end of updateProduct()
			
			
			//Adds a single product to the product table
			public void addProduct(int productID, String name, String description, float price) 
			{
		    	Product p=null;

				p = new Product (productID, name, description, price);
		    	productList.add(p);
				
			} // end of addProduct()
		    
		    public void removeProduct(int[] primaryKeys)
		    {
		    	Product p=null;
		    	for (int i=0; i<primaryKeys.length;i++) {
			    	p = getProduct(primaryKeys[i]);
			    	productList.remove(p);
			    }
			} // end of removeProduct()
		    
		    
		    public ArrayList<Product> initializeProduct(){
		    	
		    	Product p=null;
		    	productList.clear();
		    	
		    	productList.add(new Product(1, "Bravo 32' HDTV",
		                "Low-cost HDTV from renowned TV manufacturer",
		                159.95F));
		    	productList.add(new Product(2, "Bravo BluRay Player",
		                "High quality stylish BluRay player", 99.95F));
		    	productList.add(new Product(3, "Bravo Stereo System",
		                "5 speaker hifi system with iPod player", 
		                129.95F));
		    	productList.add(new Product(4, "Bravo iPod player",
		                "An iPod plug-in that can play multiple formats",
		                39.95F));		    	
		    	productList.add(new Product(5, "Onkyo Receiver",
		                "Home Theathre Receiver",
		                599.99F));		 
		    	productList.add(new Product(6, "LG 50' Plasma TV",
		                "Plasma TV",
		                499.99F));		 
		    	productList.add(new Product(7, "Toshiba DVD Player",
		                "DVD Player",
		                49.99F));	
		    	productList.add(new Product(8, "Boss Speakers",
		                "Boss Speakers",
		                449.99F));	
		    	productList.add(new Product(9, "Samsung 10' Tablet",
		                "Samsung 10' Tablet",
		                399.99F));			    	
		    	productList.add(new Product(10, "Acer 8' Tablet",
		                "Acer 8' Tablet",
		                199.99F));	
		    	
		    	return productList;
		    }

			public ArrayList<Product> getProductList() {
				return productList;
			}

			public void setProductList(ArrayList<Product> productList) {
				this.productList = productList;
			}
			
		} 