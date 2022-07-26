package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.CartService;
import service.FavoriteService;
import service.ProductCategoryService;
import service.impl.CartServiceImpl;
import service.impl.FavoriteServiceImpl;
import service.impl.ProductCategoryServiceImpl;

@WebFilter("/*")
public class FilterClient implements Filter{
	ProductCategoryService service = new ProductCategoryServiceImpl();
	CartService serviceCart = new CartServiceImpl();
	FavoriteService serviceFavorite = new FavoriteServiceImpl();
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		req.getServletContext().setAttribute("category", new Gson().toJson(service.getAll()));
		if(session.getAttribute("user_id") != null) {
			int userId = Integer.parseInt(session.getAttribute("user_id").toString());
			session.setAttribute("cart", new Gson().toJson(serviceCart.get(userId)));
			session.setAttribute("wishlist", new Gson().toJson(serviceFavorite.get(userId)));
		}
		chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
