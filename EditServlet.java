package com.Alekhyagrandhi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String uid=request.getParameter("id");
		int id=Integer.parseInt(uid);
		EmployeeDto e=EmployeeDao.getEmployeeById(id);
		pw.print("<form action='EditServlet2' method='post'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");
		pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");
		pw.print("<tr><td>Password</td><td><input type='password' name='password' value='"+e.getPassword()+"'</td></tr>");
		pw.print("<tr><td>Email</td><td><input type='email' name='email' value='"+e.getEmail()+"'</td></tr>");
		pw.print("<tr><td>country</td><td>");
		pw.print("<select name='country'>");
		pw.print("<option>America</option>");
		pw.print("<option>USA</option>");
		pw.print("<option>India</option>");
		pw.print("<option>Australia</option>");
		pw.print("</select>");
		pw.print("</td></tr>");
		pw.print("<td><input type='submit' value='edit & save'></td>");
		pw.print("</table>");
		pw.print("</form>");
		pw.close();
		}

	
}
