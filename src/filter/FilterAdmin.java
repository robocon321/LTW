package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;

@WebFilter("/admin/*")
public class FilterAdmin implements Filter {
	AdminService adminService = new AdminServiceImpl();

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		Cookie[] cookies = request.getCookies();
		String uname = "";
		if(cookies == null) {
			request.getRequestDispatcher("/admin/login").forward(req, resp);			
		}
		
		for (Cookie c : cookies) {
			if (c.getName().equals("uname")) 
				uname = c.getValue();
		}
		
		if (adminService.get(uname) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("uname",uname);
			chain.doFilter(req, resp);
		} else {
			request.getRequestDispatcher("/admin/login").forward(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
