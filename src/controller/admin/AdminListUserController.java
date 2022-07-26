package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet("/admin/user/list")
public class AdminListUserController extends HttpServlet{
	AccountService service = new AccountServiceImpl();
	
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
		req.setAttribute("accounts", service.findBetween(search));
		req.setAttribute("pages", service.showPage());
		req.setAttribute("search", search);
		req.setAttribute("index", page);
		req.getRequestDispatcher("/view/admin/user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
