package com.classes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<CartLine> cartLines = new ArrayList<CartLine>();
	Cart cart = new Cart();  
	private List<Product> products = new ArrayList<Product>();
	ProductCatalog pc = new ProductCatalog();  
    

    public AddToCartServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	
		pc.initializeProduct();
		products = pc.getProductList();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();
	    int id = 0;
	    int cart_id = 0;
	    int product_id = 0;
	    int quantity = 0;
	    try {
			HttpSession session = request.getSession();
			cart = (Cart) session.getAttribute("cart");
			cartLines = cart.getCartLines();
			id = cart.getNextCartLineNumber() ;
            cart_id = (int) session.getAttribute("cart_id");
	        product_id = Integer.parseInt(request.getParameter("id"));
	        quantity = Integer.parseInt(request.getParameter("quantity"));
	        
		    cart.addCartLine(id, cart_id, product_id, quantity);
		    session.setAttribute("cart", cart);
	    } catch (NumberFormatException e) {
	    }

	    Product product = pc.getProduct(product_id);
	        writer.println("<html><head>"
	                + "<title>Cart Line Confirmation</title></head>"
	                + "<body><h2>Below Item is Added to Cart</h2>");
	        writer.println("<table>");
	        writer.println("<tr><td>Session Cart Id:</td><td>"
	                + cart_id + "</td></tr>");
	        writer.println("<tr><td>Name:</td><td>"
	                + product.getName() + "</td></tr>");
	        writer.println("<tr><td>Description:</td><td>"
	                + product.getDescription() + "</td></tr>");
	        writer.println("<tr><td>Price:</td><td>"
	                + product.getPrice() + "</td></tr>");
	        writer.println("<tr><td>Quantity:</td><td>"
	                + quantity + "</td></tr>");
	        writer.println("<tr><td>Amount:</td><td>"
	                + product.getPrice() * quantity + "</td></tr>");
	        
	        writer.println("<tr><td><a href='products'>Product List</a></td>"
	                + "<td><a href='viewCart'>View Cart</a></td></tr>");
	        writer.println("</table>");
	        writer.println("</form></body>");
	        
	        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
