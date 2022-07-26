package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.FavoriteImplDAO;
import model.Favorite;
import service.FavoriteService;
import service.impl.FavoriteServiceImpl;

@WebServlet("/wishlist/insert")
public class InsertFavoriteController extends HttpServlet{
	FavoriteService service = new FavoriteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/client/wishlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("user_id"));
		int productId = Integer.parseInt(req.getParameter("product_id"));
				
		Favorite f = new Favorite(userId, productId);
		service.insert(f);
		doGet(req, resp);
	}
}
