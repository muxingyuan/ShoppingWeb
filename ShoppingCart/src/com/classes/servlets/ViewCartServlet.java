package com.classes.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<CartLine> cartLines = new ArrayList<CartLine>();
	Cart cart = new Cart();  
	private List<Product> products = new ArrayList<Product>();
	ProductCatalog pc = new ProductCatalog();         

    public ViewCartServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	
		pc.initializeProduct();
		products = pc.getProductList();

    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html");
	    PrintWriter writer = response.getWriter();

	    int cart_id = 0;
	    try {
			HttpSession session = request.getSession();
			cart = (Cart) session.getAttribute("cart");
			cartLines = cart.getCartLines();
            cart_id = (int) session.getAttribute("cart_id");
	    } catch (NumberFormatException e) {
	    }


	       response.setContentType("text/html");

	        writer.println("<html><head><title>View Cart</title>" +
	        		"</head><body><h2>View Cart</h2>");
	        
	        writer.println("</br><a href='products'>Product List</a></br>");
	        writer.println("<h3>Cart Id: " + cart_id + "</h3>");
	        
	        writer.println("<table>");
	        writer.println("<thead><th>Quantity</th><th>Product</th><th>Price</th><th>Amount</th></thead>");
	        writer.println("<tbody>");
	        for (CartLine cl1 : cartLines) {
	            writer.println("<tr><td>" + cl1.getQuantity() 
	                         + "</td><td>" + pc.getProduct(cl1.getProductId()).getName() 
	                         + "</td><td>" + pc.getProduct(cl1.getProductId()).getPrice() 
	                         + "</td><td>" + cl1.getQuantity() * pc.getProduct(cl1.getProductId()).getPrice() 
	                         + "</td></tr>"  );
	        }
	        writer.println("</tbody></table>");
	        writer.println("</body></html>");
	        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
