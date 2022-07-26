package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{
	AdminService adminService  = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/view/admin/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String cksave = req.getParameter("cksave");
				
		if(cksave != null) {
			req.setAttribute("ok_uname", uname);
			req.setAttribute("ok_pwd", pwd);
		}
		
		
		Admin admin = adminService.get(uname);
		
		if(admin == null ) {
			req.setAttribute("error", "Not found this username");
			req.getRequestDispatcher("/view/admin/login.jsp").forward(req, resp);			
		}else if(!admin.getPassword().equals(pwd)){
			req.setAttribute("error", "Incorrect password");
			req.getRequestDispatcher("/view/admin/login.jsp").forward(req, resp);
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("uname", uname);
			
			resp.addCookie(new Cookie("uname", uname));
			resp.addCookie(new Cookie("pwd", pwd));
			
			resp.sendRedirect("/admin/home");
		}
	}
}
