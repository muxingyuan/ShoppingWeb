package com.classes.servlets;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
		   ArrayList<CartLine> cartLines = new ArrayList<CartLine>();
		   
		   public Cart() { };
		   	
		    //Return the single CartLine object associated with the CartLine_ID
			public CartLine getCartLine(int id) 
			{
			    Iterator<CartLine> iCartLine = cartLines.iterator();
			    while (iCartLine.hasNext()) {
			      CartLine c = (CartLine) iCartLine.next();
			      if (c.getId() == id)
			    	  return c;
			    }
			    return null;
			} // end of getCartLine()

		    //Updates the cartLine information to the database
			public void updateCartLine(CartLine c) 
			{
				CartLine prevCartLine = getCartLine(c.getId());
				int index = cartLines.indexOf(prevCartLine);
				cartLines.remove(index);
		    	cartLines.add(index, c);
			} // end of updateCartLine()
			
			
			//Adds a single cartLine to cart
			public void addCartLine(int id, int cart_id, int product_id, int quantity) 
			{
		    	CartLine c=null;

				c = new CartLine (id, cart_id, product_id, quantity);
		    	cartLines.add(c);
				
			} // end of addCartLine()
		    
		    public void removeCartLine(int[] primaryKeys)
		    {
		    	CartLine c=null;
		    	for (int i=0; i<primaryKeys.length;i++) {
			    	c = getCartLine(primaryKeys[i]);
			    	cartLines.remove(c);
			    }
			} // end of removeCartLine()
		    
		    
		    public ArrayList<CartLine> initializeCartLine(){
		    	
		    	//CartLine c=null;
		    	cartLines.clear();
		    	
		    	return cartLines;
		    }

			public ArrayList<CartLine> getCartLines() {
				return cartLines;
			}

			public int getNextCartLineNumber() {
				return cartLines.size()+1;
			}

			
		} 