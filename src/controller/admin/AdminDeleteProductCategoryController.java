package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductCategoryDAO;
import dao.impl.ProductCategoryImplDAO;
import service.ProductCategoryService;
import service.impl.ProductCategoryServiceImpl;

@WebServlet("/admin/cate/product/delete")
public class AdminDeleteProductCategoryController extends HttpServlet{
	ProductCategoryService service = new ProductCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			service.delete(id);
			req.getRequestDispatcher("/admin/cate/product/list").forward(req, resp);
		}catch(Exception e) {
			resp.sendRedirect("/error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
