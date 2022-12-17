package com.jbk.product.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.product.dao.ProductDao;
import com.jbk.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		if(product.getProductId()==null) {
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProductId(id);
		}
		boolean isAdded = dao.saveProduct(product);

		return isAdded;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> sortProducts(String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double countSumOfProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCountOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Product> readExcel(String filePath) {

		FileInputStream fis = null;
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		try {
			fis = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(fis);

			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.rowIterator();

			int cnt = 0;
			while (rows.hasNext()) {
				Row row = rows.next();
				product = new Product();
			  //Thread.sleep(1);

				String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
				product.setProductId(id+cnt++);

				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					int column = cell.getColumnIndex();

					switch (column) {
					case 0: {
						product.setProductName(cell.getStringCellValue());
						break;
					}
					case 1: {
						product.setProductQty((int) cell.getNumericCellValue());
						break;
					}
					case 2: {
						product.setProductPrice((int) cell.getNumericCellValue());
						break;
					}
					case 3: {
						product.setProductType(cell.getStringCellValue());
						break;
					}

					}
				}
				list.add(product);// we will be having a complete product object as the while loop finishes its
									// execution.
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;

	}

	@Override
	public int uploadSheet(CommonsMultipartFile file, HttpSession session) {

		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();
		int count = 0;

		FileOutputStream fos = null;
		byte[] data = file.getBytes();

		try {
			System.out.println(path);
			fos = new FileOutputStream(new File(path + File.separator + fileName));
			fos.write(data);

			List<Product> list = readExcel(path + File.separator + fileName);
			count = dao.uploadProductList(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
