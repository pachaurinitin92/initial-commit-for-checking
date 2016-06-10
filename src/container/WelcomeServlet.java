package container;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		String[] fields = new String[5];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul", "root", "root");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select* from dynamicForm");
			 rs.next();
			fields[0] = rs.getString(2);
			fields[1] = rs.getString(3);
			fields[2] = rs.getString(4);
			fields[3] = rs.getString(5);
			fields[4] = rs.getString(6);

		} catch (Exception e) {
			e.printStackTrace();

		}
		request.setAttribute("fieldsName", fields);
		request.getRequestDispatcher("dynamic.jsp").forward(request, response);
	}

}
