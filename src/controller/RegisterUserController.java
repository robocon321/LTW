package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet("/register")
public class RegisterUserController extends HttpServlet{
	AccountService service = new AccountServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/client/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		Date createdDate = new Date(System.currentTimeMillis());
		String pwd = req.getParameter("pwd");
		String rePwd = req.getParameter("re-pwd");
		int createdBy = 1;
		boolean status = true;
		String agree = req.getParameter("agree");
		String error = "";
		
		if(!pwd.equals(rePwd)) {
			req.setAttribute("error", "Your password not match");
			req.getRequestDispatcher("/view/client/register.jsp").forward(req, resp);
			return ;
		}
		
		if(!phone.matches("[0-9]{10}")) {
			req.setAttribute("error", "Format phone number incorrect");
			req.getRequestDispatcher("/view/client/register.jsp").forward(req, resp);	
			return ;
		}
		
		if(!email.matches("\\S+@\\S+\\.\\S+")) {
			req.setAttribute("error", "Format email number incorrect");
			req.getRequestDispatcher("/view/client/register.jsp").forward(req, resp);	
			return ;			
		}
		
		if(service.get(uname) != null) {
			req.setAttribute("error", "Already exist this username");
			req.getRequestDispatcher("/view/client/register.jsp").forward(req, resp);	
			return ;						
		}
		
		if(agree == null) {
			req.setAttribute("error", "You must accept policy");
			req.getRequestDispatcher("/view/client/register.jsp").forward(req, resp);	
			return ;									
		}
		
		
		Account account = new Account(uname, pwd, fname, lname, address, email, phone, createdDate, createdBy, status);
		service.insert(account);
		resp.sendRedirect("/login");
		
	}
}
