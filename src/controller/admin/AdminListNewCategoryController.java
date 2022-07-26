package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewCategoryService;
import service.impl.NewCategoryServiceImpl;

@WebServlet("/admin/cate/new/list")
public class AdminListNewCategoryController extends HttpServlet{
	NewCategoryService service = new NewCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		req.setAttribute("cates", service.findBetween(search));
		req.setAttribute("pages", service.showPage());
		req.setAttribute("search", search);
		req.setAttribute("index", page);		
		req.getRequestDispatcher("/view/admin/show-cate-new.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
