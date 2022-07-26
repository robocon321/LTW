package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import service.CartService;
import service.impl.CartServiceImpl;

@WebServlet("/cart/insert")
public class InsertCartController extends HttpServlet{
	CartService service = new CartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int userId = Integer.parseInt(req.getParameter("user_id"));
			int productId = Integer.parseInt(req.getParameter("product_id"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			
			service.addToCart(new Cart(userId, productId, quantity));
		}catch(Exception e) {
			resp.sendRedirect("/error");
			return; 
		}
		resp.sendRedirect("/cart/list");
	}
}
