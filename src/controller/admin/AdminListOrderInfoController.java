package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderInfoService;
import service.impl.OrderInfoServiceImpl;

@WebServlet("/admin/order/list")
public class AdminListOrderInfoController extends HttpServlet{
	OrderInfoService service = new OrderInfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		try {
			page = Integer.parseInt(req.getParameter("page"));
		}catch(Exception e) {
			page = 1;
		}
		service.setPage(page);
		String search = req.getParameter("search") == null ? "": req.getParameter("search").trim();
		req.setAttribute("order", service.findBetween(search));
		req.setAttribute("pages", service.showPage());
		req.setAttribute("search", search);
		req.setAttribute("index", page);		
		req.getRequestDispatcher("/view/admin/show-order-info.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
