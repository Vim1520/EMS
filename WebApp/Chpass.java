import java.io.IOException;  
import java.io.PrintWriter;     
import javax.servlet.http.HttpSession;  
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

public class Chpass extends HttpServlet{

    static Connection con=null;
    static String pass=null;
    static String id = null;
    static int id2;
    public static void connection()  {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","Vimal@2002");
             
       } catch (Exception e) {
           System.out.println(e);
       }
  }

    public void doPost(HttpServletRequest req,HttpServletResponse res){
        HttpSession session=req.getSession();
        id = (String) session.getAttribute("EmpID");
        id2=Integer.parseInt(id);
        pass=req.getParameter("pass");
        chpass(res);
       // ResultSet rs=smt.executeQuery();
			
    }



    static void chpass(HttpServletResponse res) {
		PreparedStatement smt=null;
		try {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter(); 
			connection();
			String query = "UPDATE EMPLOYEEDB SET PASS=? WHERE EMPID=?";
			smt=con.prepareStatement(query);
			System.out.println("Enter the New Password :");
			smt.setString(1, pass);
			smt.setInt(2, id2);	
            int cnt=0;
			cnt=smt.executeUpdate();
            if(cnt!=0){
                out.print("<h1>PassWord changed Successfully</h1>");
            }
            else{
                out.print("<h1>Invalid ID</h1>");
            }
            out.print("<form action=\"Redirect\" method=\"post\"><h1><center>Go Back</center>");
            out.print("</h1><center>To Go Back to the Main Menu !!!<table><tr><td><input type=\"submit\" value=\"__\"></td>");
		    out.print("</tr></center></table></form>");
		

		}
		catch (Exception e) {
			System.out.println(e);
			}
	}

}


