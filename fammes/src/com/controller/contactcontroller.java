package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.contact;
import com.bean.signup;
import com.dao.contactdao;
import com.dao.signupdao;
import com.service.Services;

/**
 * Servlet implementation class contactcontroller
 */
@WebServlet("/contactcontroller")
public class contactcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			
			if(action.equalsIgnoreCase("contact"))
			{
				contact c1 = new contact();
				c1.setFname(request.getParameter("fname"));
				c1.setEmail(request.getParameter("email"));
				c1.setSubject(request.getParameter("subject"));
				c1.setMessage(request.getParameter("message"));
				contactdao.insertcontact(c1);
				request.setAttribute("msg", "contact saved successfully");
				request.getRequestDispatcher("contact.jsp").forward(request, response);
			}
			else if(action.equalsIgnoreCase("signup"))
			{
				boolean flag = signupdao.checkemail(request.getParameter("email"));
				
				if(flag == true)
				{
					request.setAttribute("msg", "email id alreay register");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
				else 
					{
							if(request.getParameter("psw").equals(request.getParameter("cpsw")))
						{
						signup s1 = new signup();
						s1.setFname(request.getParameter("fname"));
						s1.setEmail(request.getParameter("email"));
						s1.setMobile(Long.parseLong(request.getParameter("mobile")));
						s1.setAddress(request.getParameter("address"));
						s1.setPsw(request.getParameter("psw"));
						s1.setCpsw(request.getParameter("cpsw"));
						s1.setGender(request.getParameter("gender"));
						s1.setUsertype(request.getParameter("usertype"));
						signupdao.insertsignup(s1);
						request.setAttribute("msg", "signup successfully");
						request.getRequestDispatcher("signup.jsp").forward(request, response);
						}
						else
						{
							request.setAttribute("msg", "psw/cpsw doesnot match");
							request.getRequestDispatcher("signup.jsp").forward(request, response);
						}
					}
				}
			else if(action.equalsIgnoreCase("login"))
			{
				signup s1 = signupdao.loginmail(request.getParameter("email"), request.getParameter("psw"));
				
				if(s1==null)
				{
					request.setAttribute("msg", "email wrong/invalid");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else 
					{
						if(s1.getUsertype().equals("user"))
					{
						HttpSession session = request.getSession();
						session.setAttribute("u", s1);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
						else
					{
						HttpSession session = request.getSession();
						session.setAttribute("u", s1);
						request.getRequestDispatcher("seller_index.jsp").forward(request, response);
					}
				}
			}
			else if(action.equalsIgnoreCase("changepsw"))
			{
				HttpSession session = request.getSession();
				signup s1 = (signup)session.getAttribute("u");
				
				
				if(s1.getUsertype().equals("user"))
				{
				if(s1.getPsw().equals(request.getParameter("opsw")))
				{
					if(request.getParameter("npsw").equals(request.getParameter("cpsw")))
					{
						signupdao.changepsw(s1.getEmail(), request.getParameter("npsw"));
						response.sendRedirect("logout.jsp");
					}
					else
					{
						request.setAttribute("msg", "psw/cnpsw doesnot matched");
						request.getRequestDispatcher("changenewpsw.jsp").forward(request, response);	
					}
				}
				else
				{
					request.setAttribute("msg", "psw not matched");
					request.getRequestDispatcher("changenewpsw.jsp").forward(request, response);
				}
				}
				else if(s1.getUsertype().equals("seller"))
				{
					if(s1.getPsw().equals(request.getParameter("opsw")))
					{
						if(request.getParameter("npsw").equals(request.getParameter("cpsw")))
						{
							signupdao.changepsw(s1.getEmail(), request.getParameter("npsw"));
							response.sendRedirect("logout.jsp");
						}
						else
						{
							request.setAttribute("msg", "psw/cnpsw doesnot matched");
							request.getRequestDispatcher("seller_changenewpsw.jsp").forward(request, response);	
						}
						
					}
					else
					{
						request.setAttribute("msg", "psw not matched");
						request.getRequestDispatcher("seller_changenewpsw.jsp").forward(request, response);
					}
				}


			}
			else if(action.equalsIgnoreCase("updateform"))
			{
				signup s1 = new signup();
				s1.setId(Integer.parseInt(request.getParameter("id")));
				s1.setFname(request.getParameter("fname"));
				s1.setEmail(request.getParameter("email"));
				s1.setMobile(Long.parseLong(request.getParameter("mobile")));
				s1.setAddress(request.getParameter("address"));
				s1.setUsertype(request.getParameter("usertype"));
				signupdao.updateform(s1);
				HttpSession session = request.getSession();
				session.setAttribute("u", s1);

				
				if(s1.getUsertype().equals("user"))
				{
					request.getRequestDispatcher("profile.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("seller_profile.jsp").forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("send otp"))
			{
				String email = request.getParameter("email");
				boolean flag = signupdao.checkemail(email);
				

				if(flag==true)
				{
					int min = 1000;
					int max = 9999;
					int otp = (int)Math.floor(Math.random()*(max-min+1)+min);
					
					Services.sendMail(email, otp);
					request.setAttribute("email", email);
					request.setAttribute("otp", otp);
					
					
					request.setAttribute("msg", "otp sent successfully");
					request.getRequestDispatcher("otp.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "email-id not register");
					request.getRequestDispatcher("forgotpsw.jsp").forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("verify otp"))
			{
				String email = request.getParameter("email");
				int otp1 = Integer.parseInt(request.getParameter("otp1"));
				int otp2 = Integer.parseInt(request.getParameter("otp2"));
					
				if(otp1==otp2)
				{
					request.setAttribute("email", email);
					request.getRequestDispatcher("newpsw.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("email", email);
					request.setAttribute("otp1", otp1);
					request.setAttribute("msg", "invalid otp");
					request.getRequestDispatcher("otp.jsp").forward(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("updatepsw"))
			{
				String email = request.getParameter("email");
				String np = request.getParameter("npsw");
				String cnp = request.getParameter("cpsw");
				
				if(np.equals(cnp))
				{
					signupdao.changepsw(email, np);
					response.sendRedirect("login.jsp");
				}
				else
				{
					request.setAttribute("email", email);
					request.setAttribute("msg", "new and cpsw doesnot matched");
					request.getRequestDispatcher("newpsw.jsp").forward(request, response);
				}
			}
	}

}
