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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import model.ProductAttribute;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.FileProccess;

@WebServlet("/admin/product/edit")
@MultipartConfig
public class AdminUpdateProductController extends HttpServlet{
	ProductService service = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Product product = service.get(id);
			if(product == null) {
				resp.sendRedirect("/admin/product/list");
			}else {
				List<ProductAttribute> list = service.getAttribute(id);
				int size = list.size();
				String[] titles = new String[size];
				String[] values = new String[size];
				for(int i=0;i<size;i++) {
					System.out.println(service.getTitle(list.get(i).getTitleId()));
					titles[i] = service.getTitle(list.get(i).getTitleId()).getTitleContent();
					values[i] = service.getValue(list.get(i).getValueId()).getValueContent();
				}
				req.setAttribute("titles", titles);
				req.setAttribute("values", values);
				req.setAttribute("product", product);
				req.getRequestDispatcher("/view/admin/editproduct.jsp").forward(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
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
					new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("created_date")).getTime());
			
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
			
			Product product = new Product(id, name, description, imageMain, price, promotionsPrice, includeVat, quantity, detail, viewCount, brand, categoryId, launchDate, createdDate, createdBy, true);
			service.updateProduct(product, images, title, value);
			resp.sendRedirect("/admin/product/list");
		} catch (ParseException e) {
			e.printStackTrace();
			resp.sendRedirect("/error");
		}
	}
}
