package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import service.CartService;
import service.impl.CartServiceImpl;

@WebServlet("/cart/edit")
public class UpdateCartController extends HttpServlet {
	 CartService service = new CartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userIdStr = session.getAttribute("user_id").toString();
		String[] productIdStrs = req.getParameterValues("id");
		String[] quantityStrs = req.getParameterValues("quantity");
		


		try {
			int userId = -1;
			userId = Integer.parseInt(userIdStr);

			if(productIdStrs == null || quantityStrs == null) {
				service.delete(userId);
				resp.sendRedirect("/cart/list");		
				return ;
			}
			int[] productIds = new int[productIdStrs.length];
			int[] quantitys = new int[quantityStrs.length];
			
			for (int i = 0; i < productIdStrs.length; i++) {
				productIds[i] = Integer.parseInt(productIdStrs[i]);
				quantitys[i] = Integer.parseInt(quantityStrs[i]);
			}
			
			service.delete(userId);
			for (int i = 0; i < productIdStrs.length; i++) {
				service.insert(new Cart(userId, productIds[i], quantitys[i]));
			}
			
			resp.sendRedirect("/cart/list");		
		} catch (Exception e) {
			resp.sendRedirect("/cart/list");
			return ;
		}
		
	}
}
