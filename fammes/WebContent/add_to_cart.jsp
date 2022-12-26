<%@page import="com.dao.cartdao"%>
<%@page import="com.bean.product"%>
<%@page import="com.bean.cartbean"%>

<%
	int pid =Integer.parseInt(request.getParameter("pid"));
	
	int id = Integer.parseInt(request.getParameter("id"));
	product p = new product();
	cartbean c = new cartbean();
	c.setPid(pid);
	c.setId(id);
	c.setPqty(1);
	c.setPrice(p.getProduct_price());
	c.setTotal_price(p.getProduct_price());
	cartdao.getalldetails(c);
	response.sendRedirect("my_cart_list.jsp");
%>