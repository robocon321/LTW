package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.ProductCategoryImplDAO;
import model.ProductCategory;
import service.ProductCategoryService;
import service.impl.ProductCategoryServiceImpl;

@WebServlet("/admin/cate/product/add")
public class AdminInsertProductCategoryController extends HttpServlet{
	ProductCategoryService service = new ProductCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("all", service.getAll());
		req.getRequestDispatcher("/view/admin/add-cate-product.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String name = req.getParameter("name");
			int parentId = Integer.parseInt(req.getParameter("parentId"));
			System.out.println(service.insert(new ProductCategory(name, parentId)));
			req.getRequestDispatcher("/admin/cate/product/list").forward(req, resp);
		}catch(Exception e) {
			resp.sendRedirect("/admin/cate/product/add");
		}
	}
}