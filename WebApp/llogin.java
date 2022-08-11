




import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Login extends HttpServlet{


	static Connection con=null;
	static String id=null;
	static String pass=null;
	 public static void connection(){
		 	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Vimal@2002");
			      
			} catch (Exception e) {
				System.out.println(e);
			}
	   }


protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException , IOException{
		
		int j=0;
		id=req.getParameter("Employee_ID");
		pass=req.getParameter("password");
		String page=null;
		int id2=Integer.parseInt(id);
		try{
		connection();
		PreparedStatement smt=null;
		String query="Select Rid  from EmployeeDB where EmpID=? And Pass=?";
		smt=con.prepareStatement(query);
			smt.setInt(1, id2);
			smt.setString(2, pass);
			ResultSet rs=smt.executeQuery();
			while(rs.next()){
			j++;
			HttpSession session=req.getSession();
			session.setAttribute("EmpID",id);
				if(rs.getInt(1)==1){
					page="/SuperAdmin.jsp";
				}
				else if(rs.getInt(1)==2){
					page="/Admin.jsp";
				}
				else{
					page="/User.jsp";
				}
			}
				
		}			
		catch(Exception e){
			System.out.println(e);
		}
		if(j==0){			
				page="Error.jsp";
			}	
		//res.sendRedirect(page);
		req.getRequestDispatcher(page).include(req, res);
	}
}

