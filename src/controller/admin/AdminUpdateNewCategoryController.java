package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewCategory;
import service.NewCategoryService;
import service.impl.NewCategoryServiceImpl;

@WebServlet("/admin/cate/new/edit")
public class AdminUpdateNewCategoryController extends HttpServlet{
	NewCategoryService service = new NewCategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
		
			req.setAttribute("cate", service.get(id));
			req.setAttribute("all", service.getAll());
			req.getRequestDispatcher("/view/admin/edit-cate-new.jsp").forward(req, resp);
		}catch(Exception e) {
			resp.sendRedirect("/error");
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
			
			service.edit(new NewCategory(id, name, parentId));
			resp.sendRedirect("/admin/cate/new/list");
		}catch(Exception e) {
			resp.sendRedirect("/admin/cate/new/list");
		}
	}
}
