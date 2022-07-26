package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet("/admin/user/delete")
public class AdminDeleteUserController extends HttpServlet{
	AccountService accountService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int userId = Integer.parseInt(req.getParameter("userId"));
			accountService.disable(userId);
			resp.sendRedirect("/admin/user/list");
		}catch(Exception e) {
			resp.sendRedirect("/error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
