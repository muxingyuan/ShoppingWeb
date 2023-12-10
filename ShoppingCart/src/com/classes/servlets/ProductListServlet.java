package com.classes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<Product>();
    private NumberFormat currencyFormat = NumberFormat
            .getCurrencyInstance(Locale.US);

    @Override
    public void init() throws ServletException {
    	ProductCatalog pc = new ProductCatalog();
		pc.initializeProduct();
		products = pc.getProductList();

    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
  
		HttpSession session = request.getSession();
		if (session.getAttribute("cart_id")==null){
	        int cartId = 0;
			session.setAttribute("cart_id", cartId);
		}

		if (session.getAttribute("cart")==null){
	        Cart cart = new Cart();			
	        session.setAttribute("cart",  cart);
		}
        sendProductList(response);
    }    
    
    private void sendProductList(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Products</title>" +
        		"</head><body><h2>Products</h2>");
        writer.println("<ul>");
        for (Product product : products) {
            writer.println("<li>" + product.getName() + "("
                    + currencyFormat.format(product.getPrice())
                    + ") (" + "<a href='productDetails?id="
                    + product.getId() + "'>Details</a>)");
        }
        writer.println("</ul>");
        writer.println("<a href='viewCart'>View Cart</a>");
        writer.println("</body></html>");

    }
}
