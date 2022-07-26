package controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.New;
import model.NewCategory;
import service.NewCategoryService;
import service.NewService;
import service.impl.NewCategoryServiceImpl;
import service.impl.NewServiceImpl;
import utils.FileProccess;

@WebServlet("/admin/new/add")
@MultipartConfig
public class AdminInsertNewController extends HttpServlet{
	NewService service = new NewServiceImpl();
	NewCategoryService serviceCate = new NewCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("category", serviceCate.getAll());
		req.getRequestDispatcher("/view/admin/add-new.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String image = null;
			String detail = req.getParameter("detail");
			int viewCount = Integer.parseInt(req.getParameter("view_count"));
			Date createdDate = req.getParameter("created_date").equals("") ? null :new Date(
					new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("created_date")).getTime());
			int createdBy = Integer.parseInt(req.getParameter("created_by"));
			String[] strCategory = req.getParameterValues("category");
			int[] category = new int[strCategory.length];
			for(int i=0;i<strCategory.length;i++) {
				category[i] = Integer.parseInt(strCategory[i]);
			}
			for (Part part : req.getParts()) {
				if(part.getHeader("content-disposition").indexOf("name=\"new_image\"") > -1) {
					String path = FileProccess.extractFileName(part);
					File file = new File("C:/Users/samhangngoai/eclipse-workspace/CuoiKi/WebContent/resources/images/"+path);
					if(!file.exists()) file.createNewFile();
					BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
					BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
					FileProccess.copyFile(bout, bin);
					image = "/resources/images/"+path;
				}
			}
			New item = new New(title, description, image, detail, viewCount, createdDate, createdBy, true);
			service.addNew(item, category);
			resp.sendRedirect("/admin/new/list");
		}catch(Exception e) {
			resp.sendRedirect("/admin/new/list");
		}
	}
}
