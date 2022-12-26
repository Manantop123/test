<%@page import="com.dao.cartdao"%>
<%@page import="com.bean.cartbean"%>
<%@page import="com.dao.wishlistdao"%>
<%@page import="com.bean.wishlist"%>
<%
int pid =Integer.parseInt(request.getParameter("pid"));

int id = Integer.parseInt(request.getParameter("id"));

cartbean c1 = new cartbean();
c1.setPid(pid);
c1.setId(id);
cartdao.removecart(c1);
response.sendRedirect("my_cart_list.jsp");
%>