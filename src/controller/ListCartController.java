package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Product;
import service.CartService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet("/cart/list")
public class ListCartController extends HttpServlet{
	CartService service = new CartServiceImpl();
	ProductService serviceProduct = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userId;
		try {
			userId = Integer.parseInt(session.getAttribute("user_id").toString());
		}catch(Exception e) {
			resp.sendRedirect("/login");
			return;
		}
		List<Cart> cart = service.get(userId);
		List<Product> products = new ArrayList<Product>();
		for(Cart item : cart)
			products.add(serviceProduct.get(item.getProductId()));
		
		req.setAttribute("cartInfo", cart);
		req.setAttribute("products", products);
		req.getRequestDispatcher("/view/client/cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
