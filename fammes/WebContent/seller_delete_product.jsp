<%@page import="com.dao.productdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	int pid = Integer.parseInt(request.getParameter("pid"));
	productdao.deleteproduct(pid);
	response.sendRedirect("seller_view_product.jsp");
	
%>