package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Favorite;
import service.FavoriteService;
import service.impl.FavoriteServiceImpl;

@WebServlet("/wishlist/edit")
public class UpdateFavoriteController extends HttpServlet{
	FavoriteService service = new FavoriteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] products = req.getParameterValues("wishlist");
		if(products == null) {
			resp.sendRedirect("/wishlist/list");
			return ;
		}
		System.out.println(products.length);
		HttpSession session = req.getSession();
		int userId = Integer.parseInt(session.getAttribute("user_id").toString());
		service.delete(userId);
		for(String idStr : products) {
			int productId = Integer.parseInt(idStr);
			service.insert(new Favorite(userId, productId));
		}
		resp.sendRedirect("/wishlist/list");
	}
}
