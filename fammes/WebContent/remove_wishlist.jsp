<%@page import="com.dao.wishlistdao"%>
<%@page import="com.bean.wishlist"%>
<%
int pid =Integer.parseInt(request.getParameter("pid"));

int id = Integer.parseInt(request.getParameter("id"));

wishlist w1 =  new wishlist();
w1.setPid(pid);
w1.setId(id);
wishlistdao.removelist(w1);
response.sendRedirect("my_wish_list.jsp");
%>