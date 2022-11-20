package com.controller;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bean.product;
import com.dao.productdao;

/**
 * Servlet implementation class productcontroller
 */
@WebServlet("/productcontroller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512,//512MB
maxFileSize = 1024 * 1024 * 512, //512MB
maxRequestSize = 1024 * 1024 * 512) // 512MB

public class productcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    System.out.println(cd);
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("addproduct"))
		{
			String savePath = "D:\\manan\\github\\java19july\\fammes\\WebContent\\Product_Images";
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("product_image");
		 	String fileName=extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		
		    product p = new product();
		    p.setId(Integer.parseInt(request.getParameter("id")));
		    p.setProduct_category(request.getParameter("category"));
		    p.setProduct_name(request.getParameter("pname"));
		    p.setProduct_model(request.getParameter("model"));
		    p.setProduct_price(Integer.parseInt(request.getParameter("price")));
		    p.setProduct_image(fileName);
		    p.setProduct_Details(request.getParameter("desc"));
		    productdao.addproduct(p);
		    request.setAttribute("msg", "product add successfully");
		    request.getRequestDispatcher("seller_add_product.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("updateproduct"))
		{
			product p = new product();
			p.setPid(Integer.parseInt(request.getParameter("pid")));
			p.setProduct_category(request.getParameter("category"));
			p.setProduct_name(request.getParameter("pname"));
			p.setProduct_model(request.getParameter("model"));
			p.setProduct_price(Integer.parseInt(request.getParameter("price")));
			p.setProduct_Details(request.getParameter("desc"));
			productdao.editproduct(p);
			response.sendRedirect("seller_view_product.jsp");
		}
	}

}
