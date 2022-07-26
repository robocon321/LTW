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

@WebServlet("/admin/admin/edit")
public class AdminUpdateAdminController extends HttpServlet{
	AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String adminId = req.getParameter("adminId");
		Admin admin = null;
		try {
			admin = adminService.get(Integer.parseInt(adminId));			
		}catch(Exception e) {
			System.out.println("Can't parseInt "+adminId);
		}
				
		if(admin == null) {
			req.getRequestDispatcher("/admin/admin/list").forward(req, resp);
		}else {
			req.setAttribute("admin", admin);
			req.getRequestDispatcher("/view/admin/editadmin.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String addr = req.getParameter("addr");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		boolean status = true;
		
		if(adminService.edit(new Admin(id, uname, pwd,  fname, lname, addr, email, phone, status))) {
			resp.sendRedirect("/admin/admin/list");			
		}else {
			// Chưa xử lí lỗi
			req.setAttribute("err", "Edit admin failed");
			req.getRequestDispatcher("/admin/admin/edit?adminId="+id).forward(req, resp);
		}
	}
}
