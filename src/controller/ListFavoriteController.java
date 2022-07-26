package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Favorite;
import model.Product;
import service.FavoriteService;
import service.ProductService;
import service.impl.FavoriteServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet("/wishlist/list")
public class ListFavoriteController extends HttpServlet{
	FavoriteService service = new FavoriteServiceImpl();
	ProductService serviceProduct = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userId = 0;
		try {
			userId = Integer.parseInt(session.getAttribute("user_id").toString());			
		}catch(Exception e) {
			resp.sendRedirect("/login");
			return ;
		}
		List<Product> products = new ArrayList<Product>();

		List<Favorite> favorites = service.get(userId);
		
		for(Favorite favorite : favorites) {
			products.add(serviceProduct.get(favorite.getProductId()));
		}
		
		req.setAttribute("favorites", favorites);
		req.setAttribute("products", products);
		req.getRequestDispatcher("/view/client/wishlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
