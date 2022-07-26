package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;

@WebServlet("/admin/admin/add")
public class AdminInsertAdminController extends HttpServlet{
	AdminService adminService = new AdminServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/view/admin/addadmin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String addr = req.getParameter("addr");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		boolean status = true;
		
		if(adminService.insert(new Admin(uname, pwd,  fname, lname, addr, email, phone, status))) {
			req.getRequestDispatcher("/admin/admin/list").forward(req, resp);			
		}else {
			// Chưa xử lí lỗi
			req.setAttribute("err", "Edit admin failed");
			req.getRequestDispatcher("/admin/admin/add").forward(req, resp);
		}

	}
}
