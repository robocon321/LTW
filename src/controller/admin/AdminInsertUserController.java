package controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
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
import utils.Convert;

@WebServlet("/admin/user/add")
public class AdminInsertUserController extends HttpServlet {
	AccountService accountService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/view/admin/adduser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
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
			
			if (accountService.insert(
					new Account(uname, pwd, fname, lname, addr, phone, email, createdDate, createdBy, status))) {
				req.getRequestDispatcher("/admin/user/list").forward(req, resp);
			} else {
				// Chưa xử lí lỗi
				req.getRequestDispatcher("/error").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/error").forward(req, resp);
		}
	}
	
}
