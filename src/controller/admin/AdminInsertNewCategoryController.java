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

@WebServlet("/admin/cate/new/add")
public class AdminInsertNewCategoryController extends HttpServlet{
	NewCategoryService service = new NewCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("cate", service.getAll());
		req.getRequestDispatcher("/view/admin/add-cate-new.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			int parentId = Integer.parseInt(req.getParameter("parentId"));
			service.insert(new NewCategory(name, parentId));
			req.getRequestDispatcher("/admin/cate/new/list").forward(req, resp);
		}catch(Exception E) {
			resp.sendRedirect("/error");
		}
	}
}
