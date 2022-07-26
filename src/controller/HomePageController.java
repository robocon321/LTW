package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Product;
import model.ProductAttribute;
import model.ProductImage;
import service.ProductCategoryService;
import service.ProductService;
import service.impl.ProductCategoryServiceImpl;
import service.impl.ProductServiceImpl;

@WebServlet("/home")
public class HomePageController extends HttpServlet{
	ProductService serviceProduct = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Map<Integer, List<ProductImage>> mapImage = new HashMap<Integer, List<ProductImage>>(); 
		Map<Integer, List<ProductAttribute>> mapAttribute = new HashMap<Integer, List<ProductAttribute>>();
		
		serviceProduct.setSize(10);
		serviceProduct.setPage(1);
		List<Product> listHotDeals = serviceProduct.findBetween("");	
		
		for(Product item: listHotDeals) {
			int id = item.getProductId();
			mapImage.put(id, serviceProduct.getImages(id));
			mapAttribute.put(id, serviceProduct.getAttribute(id));
		}
		
		serviceProduct.setPage(2);
		serviceProduct.setSize(12);
		List<Product> listArrivals = serviceProduct.findBetween("");
		
		for(Product item: listArrivals) {
			int id = item.getProductId();
			mapImage.put(id, serviceProduct.getImages(id));
			mapAttribute.put(id, serviceProduct.getAttribute(id));
		}
		
		serviceProduct.setPage(3);
		serviceProduct.setSize(10);
		List<Product> listBestSeller = serviceProduct.findBetween("");

		for(Product item: listBestSeller) {
			int id = item.getProductId();
			mapImage.put(id, serviceProduct.getImages(id));
			mapAttribute.put(id, serviceProduct.getAttribute(id));
		}
		
		serviceProduct.setSize(20);
		serviceProduct.setPage(1);
		List<Product> listYouMayBe = serviceProduct.findBetween("");

		for(Product item: listYouMayBe) {
			int id = item.getProductId();
			mapImage.put(id, serviceProduct.getImages(id));
			mapAttribute.put(id, serviceProduct.getAttribute(id));
		}
				
		req.setAttribute("mapImage", new Gson().toJson(mapImage));
		req.setAttribute("mapAttribute", new Gson().toJson(mapAttribute));
		req.setAttribute("listHotDeals",listHotDeals);
		req.setAttribute("listArrivals", listArrivals);
		req.setAttribute("listBestSeller", listBestSeller);
		req.setAttribute("listYouMayBe", listYouMayBe);
		
		req.getRequestDispatcher("/view/client/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
