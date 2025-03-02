package com.Alekhyagrandhi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		EmployeeDto e=new EmployeeDto();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		int status=EmployeeDao.saveEmp(e);
		if(status>0){  
            pw.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("Index.html").include(request, response);  
        }else{  
            pw.println("Sorry! unable to save record");  
        }  
		}

}
