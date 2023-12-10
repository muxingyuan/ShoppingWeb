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

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Product> products = new ArrayList<Product>();
	ProductCatalog pc = new ProductCatalog();   

    public ProductDetailsServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	
		pc.initializeProduct();
		products = pc.getProductList();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();
    int productId = 0;
    try {
        productId = Integer.parseInt(
                request.getParameter("id"));
    } catch (NumberFormatException e) {
    }
    //Product product = getProduct(productId);
    Product product = pc.getProduct(productId);
    if (product != null) {
        writer.println("<html><head>"
                + "<title>Product Details</title></head>"
                + "<body><h2>Product Details</h2>"
                + "<form method='post' action='addToCart'>");
        writer.println("<input type='hidden' name='id' "
        		+ "value='" + productId + "'/>");
        writer.println("<table>");
        writer.println("<tr><td>Name:</td><td>"
                + product.getName() + "</td></tr>");
        writer.println("<tr><td>Description:</td><td>"
                + product.getDescription() + "</td></tr>");
        writer.println("<tr>" + "<tr>"
                + "<td>Quantity:</td>"
        		+ "<td><input name='quantity'/></td>"
                + "<td><input type='submit' value='Buy'/>"
                + "</td>"
                + "</tr>");
       
        writer.println("<tr><td><a href='products'>Product List</a></td>"
                + "<td><a href='viewCart'>View Cart</a></td></tr>");
        writer.println("</table>");
        writer.println("</form></body>");
        
    } else {
        writer.println("No product found");
    }

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}