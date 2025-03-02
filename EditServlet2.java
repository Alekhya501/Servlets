package com.Alekhyagrandhi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String uid=request.getParameter("id");
		int id=Integer.parseInt(uid);
		String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");
        EmployeeDto e=new EmployeeDto();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmployeeDao.updateEmp(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            pw.print("Sorry! unable to update record");  
        }  
          
        pw.close();  
		}

}
