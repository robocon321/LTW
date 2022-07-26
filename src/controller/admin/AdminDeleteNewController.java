package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewService;
import service.impl.NewServiceImpl;

@WebServlet("/admin/new/delete")
public class AdminDeleteNewController extends HttpServlet{
	NewService service = new NewServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			service.disable(id);
			resp.sendRedirect("/admin/new/list");
		}catch(Exception e) {
			resp.sendRedirect("/admin/new/list");
		}
	}
	
}
