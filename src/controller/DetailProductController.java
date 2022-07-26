package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductImage;
import service.ProductImageService;
import service.ProductService;
import service.impl.ProductImageServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet("/product")
public class DetailProductController extends HttpServlet{
	ProductService service = new ProductServiceImpl();
	ProductImageService serviceImage = new ProductImageServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		}catch(Exception e) {
			resp.sendRedirect("/home");
			return ;
		}
		
		Product product = service.get(id);
		
		if(product == null) {
			resp.sendRedirect("/home");
			return ;			
		}
		List<ProductImage> images = serviceImage.getImages(product.getProductId());
		
		req.setAttribute("product", product);
		req.setAttribute("images", images);
		req.getRequestDispatcher("/view/client/product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
