<%@page import="com.bean.signup"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
      <!-- Basic -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Site Metas -->
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <link rel="shortcut icon" href="images/favicon.png" type="">
      <title>Famms - Fashion HTML Template</title>
      <!-- bootstrap core css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
      <!-- font awesome style -->
      <link href="css/font-awesome.min.css" rel="stylesheet" />
      <!-- Custom styles for this template -->
      <link href="css/style.css" rel="stylesheet" />
      <!-- responsive style -->
      <link href="css/responsive.css" rel="stylesheet" />
   </head>
<body>
<div class="hero_area">
         <!-- header section strats -->
         <header class="header_section">
            <div class="container">
               <nav class="navbar navbar-expand-lg custom_nav-container ">
                  <a class="navbar-brand" href="index.jsp"><img width="250" src="images/logo.png" alt="#" /></a>
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class=""> </span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                     <ul class="navbar-nav">
                        <li class="nav-item active">
                           <a class="nav-link" href="seller_index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                      
     <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true"> <span class="nav-label">Product <span class="caret"></span></a>
                           <ul class="dropdown-menu">
                              <li><a href="seller_add_product.jsp">Add product</a></li>
                              <li><a href="seller_view_product.jsp">View product</a></li>
                           </ul>
                        </li>

                           <%
								signup s1 = null;
    		  					
    		  					if(session!=null)
    		  					{
    		  						if(session.getAttribute("u")!=null)
    		  						{
    		  							s1 = (signup)session.getAttribute("u");
    		  				%>
    		  			<li class="nav-item">
                           <a class="nav-link" href="seller_profile.jsp">Profile</a>
                        </li>
	                   <li class="nav-item">
                           <a class="nav-link" href="seller_changenewpsw.jsp">Change password</a>
                        </li>
						<li class="nav-item">
                           <a class="nav-link" href="logout.jsp">Logout,(<%=s1.getFname() %>)</a>
                        </li>
     		  					
    		  				<% 
    		  						}
    		  						else
    		  						{
    		  				%>
		                <li class="nav-item">
                           <a class="nav-link" href="signup.jsp">Signup</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="login.jsp">login</a>
                        </li>			    		  							
    		  				<%			
    		  						}
    		  					}
                           %>

                                         </div>
               </nav>
            </div>
         </header>
         <!-- end header section -->

</body>
</html>