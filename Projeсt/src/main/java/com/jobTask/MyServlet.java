import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


@WebServlet(urlPatterns="/MyUrl", loadOnStartup = 1)
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String dbURL = "jdbc:derby://localhost:1527/sample;create=true";
	private static String tableName = "test";
	private static Connection conn = null;
    private static Statement stmt = null;
    private String currentName;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnection();
		getInformation();
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html");
		//response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter outData = response.getWriter();
		request.setAttribute("message", currentName);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		outData.println("<h2>"+currentName+"</h2>");
		outData.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createConnection();
		request.setCharacterEncoding("UTF-8");
		changeInformation(request.getParameter("value"));
		
		doGet(request,response);
	}
	
	private void createConnection() {
		try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbURL,"user","111"); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
	}
	private void getInformation() {
		try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            
            while(results.next()){
                currentName = results.getString(1);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	private void changeInformation(String value) {
		try
        {
            stmt = conn.createStatement();
            
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            
            while(results.next()){
                currentName = "'"+results.getString(1)+"'";
            }
            System.out.println(currentName);
            String result = "'"+value+"'";
            
            
            stmt.executeUpdate("UPDATE " + tableName + " SET name = "+result+" WHERE name = "+currentName);
            
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
}