package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductCategoryDAO;
import model.ProductCategory;
import service.ProductCategoryService;
import service.impl.ProductCategoryServiceImpl;

@WebServlet("/admin/cate/product/edit")
public class AdminUpdateProductCategoryController extends HttpServlet{
	ProductCategoryService service = new ProductCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			ProductCategory cate =  service.get(id);
			if(cate == null) {
				resp.sendRedirect("/admin/cate/product/list");				
			}else {
				req.setAttribute("cate", cate);
				req.setAttribute("all", service.getAll());
				req.getRequestDispatcher("/view/admin/edit-cate-product.jsp").forward(req, resp);				
			}
		}catch(Exception e) {
			resp.sendRedirect("/admin/cate/product/list");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int parentId = Integer.parseInt(req.getParameter("parentId"));
			ProductCategory cate = new ProductCategory(id, name, parentId);
			service.edit(cate);
			resp.sendRedirect("/admin/cate/product/list");
		}catch(Exception e) {
			resp.sendRedirect("/error");
		}
	}
}
