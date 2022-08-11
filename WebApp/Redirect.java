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
import java.text.*;

public class Redirect extends HttpServlet{
    
    static Connection con=null;
    static String id=null;
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
        int j=0;
        String page=null;
        try{
            connection();
            PreparedStatement smt=null;
            String query="Select Rid  from EmployeeDB where EmpID=?";
            smt=con.prepareStatement(query);
            smt.setInt(1, id2);
			ResultSet rs=smt.executeQuery();
            rs.next();
            if(rs.getInt(1)==1){
                page="SuperAdmin.jsp";
            }
            else if(rs.getInt(1)==2){
                page="Admin.jsp";
            }  res.sendRedirect(page);
        }
        catch(Exception e){
            System.out.println(e);
        }
        }          
            
    }

}