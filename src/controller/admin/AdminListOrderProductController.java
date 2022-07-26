package controller.admin;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderProduct;
import service.OrderProductService;
import service.ProductService;
import service.impl.OrderInfoServiceImpl;
import service.impl.OrderProductServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet("/admin/order/detail/list")
public class AdminListOrderProductController extends HttpServlet{
	OrderProductService service= new OrderProductServiceImpl();
	ProductService serviceProduct = new ProductServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int page = 1;
			try {
				page = Integer.parseInt(req.getParameter("page"));
			}catch(Exception e) {
				page = 1;
			}
			service.setPage(page);
			String search = req.getParameter("search") == null ? "": req.getParameter("search").trim();
			List<OrderProduct> products = service.findBetween(search);
			List<Integer> cost = new ArrayList<Integer>();
			int pay = 0;
			for(OrderProduct item : products) {
				int price = serviceProduct.get(item.getProductId()).getPromotionPrice();
				cost.add(price);
				pay += price;
			}
			
			req.setAttribute("pay", pay);
			req.setAttribute("cost", cost);
			req.setAttribute("products", products);
			req.setAttribute("pages", service.showPage());
			req.setAttribute("search", search);
			req.setAttribute("index", page);
			req.getRequestDispatcher("/view/admin/show-order-product.jsp").forward(req, resp);
		}catch(Exception e) {
			resp.sendRedirect("/admin/order/list");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
