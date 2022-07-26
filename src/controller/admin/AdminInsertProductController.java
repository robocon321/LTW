package controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import model.ProductAttribute;
import service.ProductAttributeService;
import service.ProductImageService;
import service.ProductService;
import service.ProductTitleService;
import service.impl.ProductAttributeServiceImpl;
import service.impl.ProductImageServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.ProductTitleServiceImpl;
import utils.FileProccess;

@WebServlet("/admin/product/add")
@MultipartConfig
public class AdminInsertProductController extends HttpServlet {
	ProductService service = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/view/admin/addproduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			String imageMain = null;
			int price = Integer.parseInt(req.getParameter("price"));
			int promotionsPrice = Integer.parseInt(req.getParameter("promotions_price"));
			boolean includeVat = Boolean.parseBoolean(req.getParameter("vat"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			String detail = req.getParameter("detail");
			int viewCount = Integer.parseInt(req.getParameter("view_count"));
			String brand = req.getParameter("brand");
			int categoryId = Integer.parseInt(req.getParameter("category_id"));
			
			Date launchDate = req.getParameter("launch_date").equals("") ? null :new Date(
					new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("launch_date")).getTime());
			
			Date createdDate = req.getParameter("created_date").equals("") ? null :new Date(
					new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("created_date")).getTime());
			int createdBy = Integer.parseInt(req.getParameter("created_by"));
			ArrayList<String> images = new ArrayList<String>();
			
			for (Part part : req.getParts()) {
				if(part.getHeader("content-disposition").indexOf("name=\"images\"") > -1) {
					String path = FileProccess.extractFileName(part);
					File file = new File("C:/Users/samhangngoai/eclipse-workspace/CuoiKi/WebContent/resources/images/"+path);
					if(!file.exists()) file.createNewFile();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
					BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
					FileProccess.copyFile(bout, bin);
					images.add("/resources/images/"+path);
				}
				if(part.getHeader("content-disposition").indexOf("name=\"image_main\"") > -1) {
					String path = FileProccess.extractFileName(part);
					File file = new File("C:/Users/samhangngoai/eclipse-workspace/CuoiKi/WebContent/resources/images/"+path);
					if(!file.exists()) file.createNewFile();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
					BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
					FileProccess.copyFile(bout, bin);
					imageMain = "/resources/images/"+path;
				}
			}
			String[] title = req.getParameterValues("name_attribute");
			String[] value = req.getParameterValues("value_attribute");
			
			Product product = new Product(name, description, imageMain, price, promotionsPrice, includeVat, quantity, detail, viewCount, brand, categoryId, launchDate, createdDate, createdBy, true);
			service.addProduct(product, images, title, value);
			resp.sendRedirect("/admin/product/list");
		} catch (ParseException e) {
			e.printStackTrace();
			resp.sendRedirect("/error");
		}
	}
	
}
