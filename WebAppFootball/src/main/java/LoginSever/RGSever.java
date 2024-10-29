package LoginSever;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RGSever
 */
public class RGSever extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RGSever() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String regusername = request.getParameter("username");
        String reguserpass = request.getParameter("password");

        try {
            if (registerUser(regusername, reguserpass)) {
                response.getWriter().append("Account registered successfully!");
            } else {
                response.getWriter().append("Failed to register account.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().append("Database error: ").append(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/LoginPage.jsp").forward(request,response);
	}

	private boolean registerUser(String username, String password) throws SQLException, ClassNotFoundException {
        Connection conn = DataConnect.getConnection();
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            return stmt.executeUpdate() > 0;
        } finally {
            DataConnect.closeConnection(conn);
        }
    }
}
