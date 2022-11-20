<%
	session.removeAttribute("s1");
	session.invalidate();
	response.sendRedirect("login.jsp");
%>