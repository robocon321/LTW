package controller.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.impl.ListNewCategoryImplDAO;
import model.ListNewCategory;
import model.New;
import model.NewCategory;
import service.ListNewCategoryService;
import service.NewCategoryService;
import service.NewService;
import service.impl.ListNewCategoryServiceImpl;
import service.impl.NewCategoryServiceImpl;
import service.impl.NewServiceImpl;
import utils.FileProccess;

@WebServlet("/admin/new/edit")
@MultipartConfig
public class AdminUpdateNewController extends HttpServlet{
	NewService service = new NewServiceImpl();
	NewCategoryService serviceCate = new NewCategoryServiceImpl();
	ListNewCategoryService serviceListCate = new ListNewCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			req.setAttribute("listCate", serviceCate.getAll());

			int id = Integer.parseInt(req.getParameter("id"));
			New item = service.get(id);
			req.setAttribute("item", item);
			
			List<ListNewCategory> list = serviceListCate.getCategorys(id);
			
			String[] strCate = new String[list.size()];
			int[] intCate = new int[list.size()];
			
			for(int i=0;i<intCate.length;i++) {
				strCate[i] = serviceCate.get(list.get(i).getNewCategoryId()).getName();
				intCate[i] = list.get(i).getNewCategoryId();
			}
						
			req.setAttribute("category", serviceCate.getAll());
			req.setAttribute("intCate", intCate); 
			req.setAttribute("strCate", strCate);
			req.getRequestDispatcher("/view/admin/edit-new.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/admin/new/list");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			int id = Integer.parseInt(req.getParameter("id"));
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
			New item = new New(id, title, description, image, detail, viewCount, createdDate, createdBy, true);
			service.updateNew(item, category);
			resp.sendRedirect("/admin/new/list");
		}catch(Exception e) {
			resp.sendRedirect("/admin/new/list");
		}
		
	}
}
