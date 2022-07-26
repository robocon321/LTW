package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewCategoryService;
import service.impl.NewCategoryServiceImpl;

@WebServlet("/admin/cate/new/delete")
public class AdminDeleteNewCategoryController extends HttpServlet{
	NewCategoryService service = new NewCategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			service.delete(id);
			resp.sendRedirect("/admin/cate/new/list");
		}catch(Exception e) {
			resp.sendRedirect("/error");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
