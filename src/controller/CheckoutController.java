package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.OrderInfo;
import model.OrderProduct;
import model.Product;
import service.CartService;
import service.OrderInfoService;
import service.OrderProductService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.OrderInfoServiceImpl;
import service.impl.OrderProductServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet{
	CartService service = new CartServiceImpl();
	ProductService serviceProduct =  new ProductServiceImpl();
	OrderInfoService serviceOrderInfo = new OrderInfoServiceImpl();
	OrderProductService serviceOrderProduct = new OrderProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

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
		req.getRequestDispatcher("/view/client/checkout.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		Date createdDate = new Date(System.currentTimeMillis());
		int createdBy = 1;
		boolean status = true;
		
		if(!phone.matches("[0-9]{10}")) {
			req.setAttribute("error", "Format phone number incorrect");
			doGet(req, resp);
			return ;
		}
		
		if(!email.matches("\\S+@\\S+\\.\\S+")) {
			req.setAttribute("error", "Format email number incorrect");
			doGet(req, resp);
			return ;			
		}
		
		OrderInfo infoOrder = new OrderInfo(fname, lname, address, phone, email, createdDate, createdBy, status);
		serviceOrderInfo.insert(infoOrder);
		
		HttpSession session = req.getSession();
		int userId;
		try {
			userId = Integer.parseInt(session.getAttribute("user_id").toString());
		}catch(Exception e) {
			resp.sendRedirect("/login");
			return;
		}
		List<Cart> list = service.get(userId);
		
		for(Cart item: list) {
			serviceOrderProduct.insert(new OrderProduct(serviceOrderInfo.getCurrentId(), item.getProductId(), item.getQuantity(), new Date(createdDate.getTime()+24*60*60*1000*2), status));
		}
		
		service.delete(userId);
		
		resp.sendRedirect("/home");
	}
}
