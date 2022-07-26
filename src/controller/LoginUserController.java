package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet("/login")
public class LoginUserController extends HttpServlet{
	AccountService service = new AccountServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/client/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(service.login(uname, pwd)) {
			HttpSession session = req.getSession();
			session.setAttribute("user_id", service.get(uname).getUserId());
			resp.sendRedirect("/home");
		}else {
			req.setAttribute("uname_in", uname);
			if(service.get(uname) == null) {
				req.setAttribute("error_uname", "Tài khoản không tồn tại");				
			}else {
				req.setAttribute("error_pwd", "Sai mật khẩu");
			}
			
			doGet(req, resp);
		}
		
	}
}
