package controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.Admin;
import service.AccountService;
import service.impl.AccountServiceImpl;
import sun.print.resources.serviceui;

@WebServlet("/admin/user/edit")
public class AdminUpdateUserController extends HttpServlet{
	AccountService accountService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String userId = req.getParameter("userId");
		Account account = null;
		try {
			account = accountService.get(Integer.parseInt(userId));			
		}catch(Exception e) {
			System.out.println("Can't parseInt "+account);
		}
				
		if(account == null) {
			req.getRequestDispatcher("/admin/user/list").forward(req, resp);
		}else {
			req.setAttribute("acc", account);
			req.getRequestDispatcher("/view/admin/edituser.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("userId"));
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String addr = req.getParameter("addr");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			Date createdDate = req.getParameter("created_date").equals("") ? null :new Date(
					new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("created_date")).getTime());
			int createdBy = Integer.parseInt(req.getParameter("created_by"));
			boolean status = true;
						
			Account account = new Account(id, uname, pwd, fname, lname, addr, email, phone, createdDate, createdBy, status);
			if (accountService.edit(account)) {
				resp.sendRedirect("/admin/user/list");
			} else {
				// Chưa xử lí lỗi
				req.getRequestDispatcher("/error").forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println(3);
			e.printStackTrace();
			req.getRequestDispatcher("/error").forward(req, resp);
		}

	}
}
