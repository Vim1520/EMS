import java.io.IOException;   
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

public class Logout extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
    request.getRequestDispatcher("Login.jsp").include(request, response); 
HttpSession session = request.getSession();
session.invalidate();
    }

}