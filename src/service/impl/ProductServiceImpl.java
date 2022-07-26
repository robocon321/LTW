package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ProductAttributeDAO;
import dao.ProductDAO;
import dao.ProductImageDAO;
import dao.ProductTitleDAO;
import dao.ProductValueDAO;
import dao.impl.ProductAttributeImplDAO;
import dao.impl.ProductImageImplDAO;
import dao.impl.ProductImplDAO;
import dao.impl.ProductTitleImpleDAO;
import dao.impl.ProductValueImplDAO;
import model.Account;
import model.Product;
import model.ProductAttribute;
import model.ProductImage;
import model.ProductTitle;
import model.ProductValue;
import service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDAO dao = new ProductImplDAO();
	ProductImageDAO daoImage = new ProductImageImplDAO();
	ProductAttributeDAO daoAttribute = new ProductAttributeImplDAO();
	ProductValueDAO daoValue = new ProductValueImplDAO();
	ProductTitleDAO daoTitle = new ProductTitleImpleDAO();
	private int start = 0;
	private int size = 10;
	private int countData = 0;

	@Override
	public boolean insert(Product product) {
		return dao.insert(product);
	}

	@Override
	public boolean edit(Product product) {
		return dao.edit(product);
	}

	@Override
	public boolean enable(int id) {
		return dao.enable(id);
	}

	@Override
	public boolean disalbe(int id) {
		return dao.disalbe(id);
	}

	@Override
	public Product get(int id) {
		return dao.get(id);
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = dao.getAll();
		countData = list.size();
		return list;
	}

	@Override
	public int getCurrentId() {
		return dao.getCurrentId();
	}

	@Override
	public void addProduct(Product product, ArrayList<String> images, String[] title, String[] value) {
		dao.insert(product);		
		int currentId = dao.getCurrentId();
		for(String image : images) {
			daoImage.insert(new ProductImage(currentId, image));			
		}
		if(title != null) {
			for(int i=0;i<title.length;i++) {
				String currentTitle = title[i];
				String currentValue = value[i];
				int titleId = -1, valueId = -1;
				
				if(daoTitle.find(currentTitle) > -1) {
					titleId = daoTitle.find(currentTitle);
				}else {
					daoTitle.insert(new ProductTitle(currentTitle));
					titleId = daoTitle.getCurrentId();
				}
				
				daoValue.insert(new ProductValue(currentValue, titleId));
				valueId = daoValue.getCurrentId();
				daoAttribute.insert(new ProductAttribute(currentId, titleId, valueId));
			}	
		}
	}

	@Override
	public List<ProductAttribute> getAttribute(int productId) {
		return daoAttribute.getAttributes(productId);
	}

	@Override
	public ProductTitle getTitle(int titleId) {
		return daoTitle.get(titleId);
	}

	@Override
	public ProductValue getValue(int valueId) {
		return daoValue.get(valueId);
	}

	@Override
	public void updateProduct(Product product, ArrayList<String> images, String[] title, String[] value) {
		if(edit(product)) {
			int currentId = product.getProductId();
			List<ProductImage> listImage = daoImage.getImages(currentId);
			for(ProductImage item : listImage) daoImage.delete(item);
			for(String item: images) daoImage.insert(new ProductImage(currentId, item));
			List<ProductAttribute> listAttribuge = daoAttribute.getAttributes(currentId);
			for(ProductAttribute attr : listAttribuge) daoAttribute.delete(attr);

			if(title != null) {
				for(int i=0;i<title.length;i++) {
					String currentTitle = title[i];
					String currentValue = value[i];
					int titleId = -1, valueId = -1;
					
					if(daoTitle.find(currentTitle) > -1) {
						titleId = daoTitle.find(currentTitle);
					}else {
						daoTitle.insert(new ProductTitle(currentTitle));
						titleId = daoTitle.getCurrentId();
					}
					
					daoValue.insert(new ProductValue(currentValue, titleId));
					valueId = daoValue.getCurrentId();
					daoAttribute.insert(new ProductAttribute(currentId, titleId, valueId));
				}
			}			
		}
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public List<Product> findBetween(String search) {
		List<Product> list = dao.findBetween(search, start, size);
		countData = dao.count(search);
		return list;
	}

	@Override
	public int countPage() {
		return countData/size + 1;
	}

	@Override
	public int posPage() {
		return countData%size == 0 ? (start+1)/size : (start+1)/size+1;
	}

	@Override
	public int[] showPage() {
		int countPage = countPage();
		if(countPage < 3) {
			int[] result = new int[countPage]; 
			for(int i=0;i<result.length;i++)
				result[i] = i+1;
			return result;
		}else {
			int[] result = new int[3];
			int posPage = posPage();
			if(posPage <= 1) {
				result[0] = 1;
				result[1] = 2;
				result[2] = 3;
			}else if(posPage >= countPage) {
				result[0] = countPage-2;
				result[1] = countPage-1;
				result[2] = countPage;				
			}else {
				result[0] = posPage-1;
				result[1] = posPage;
				result[2] = posPage+1;
			}
			return result;
		}
	}

	@Override
	public void setPage(int page) {
		start = (page-1)*size;
		if(start < 0) start = 0;
	}

	public static void main(String[] args) {
		new ProductServiceImpl().showPage();
	}

	@Override
	public List<ProductImage> getImages(int productId) {
		return daoImage.getImages(productId);
	}
}
