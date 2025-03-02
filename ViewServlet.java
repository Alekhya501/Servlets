package com.Alekhyagrandhi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.print("<h4><a href='Index.html'>Add New Employee</a></h4>");
		pw.print("<h1>Employee1 List</h2>");
		
		List<EmployeeDto> list=EmployeeDao.getAllEmployees();
		pw.print("<table border=2px>");
		pw.print("<tr>");
		pw.print("<th>Id</th>");
		pw.print("<th>Name</th>");
		pw.print("<th>Password</th>");
		pw.print("<th>Email</th>");
		pw.print("<th>Country</th>");
		pw.print("<th>Edit</th>");
		pw.print("<th>Delete</th>");
		pw.print("</tr>");
		for(EmployeeDto e:list) {
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+
		e.getCountry()+"</td>");
			pw.print("<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>");
			pw.print("<td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
			
		}
		pw.print("</table>");
		pw.close();
		
	}

	
	

}
