package com.Alekhya;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try {
			response.setContentType("text/html");
			Connection con=DataBaseCon.getcon();
			String query="select *from userdetails";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			pw.print("<table border=5"
					+ ">");
			pw.print("<tr>");
			pw.print("<th>username</th>");
			pw.print("<th>password</th>");
			pw.print("<th>email</th>");
			pw.print("<th>edit</th>");
			pw.print("<th>delete</th>");
			pw.print("</tr>");
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td><a href='Edit?uusername="+rs.getString(1)+"&upassword="+rs.getString(2)+"&uemail="+rs.getString(3)+"'>edit</a></td>");
				pw.print("<td><a href='Delete?uusername="+rs.getString(1)+"'>delete</a></td>");
				pw.print("</tr>");
			}
			pw.print("</table>");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
