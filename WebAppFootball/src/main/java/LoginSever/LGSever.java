package LoginSever;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LGSever extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LGSever() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Check if a session exists
        String action = request.getParameter("action");

        if ("Logout".equals(action)) { // Log out user if action is 'Logout'
            if (session != null) {
                session.invalidate();
                response.getWriter().append("You have been logged out.");
            } else {
                response.getWriter().append("No session to log out from.");
            }
        } else if (session != null && session.getAttribute("username") != null) {
            response.getWriter().append("Already logged in as: ").append((String) session.getAttribute("username"));
        } else {
            response.getWriter().append("Please login.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("Login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            try {
                if (isValidUser(username, password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    response.getWriter().append("Login successful. Welcome, ").append(username).append("!");
                } else {
                    response.getWriter().append("Invalid username or password.");
                }
            } catch (SQLException | ClassNotFoundException e) {
                response.getWriter().append("Connection error: ").append(e.getMessage());
            }
        } else if ("Register".equals(action)) {
        	getServletContext().getRequestDispatcher("/RegisPage.jsp").forward(request,response);
        }
    }

    private boolean isValidUser(String username, String password) throws SQLException, ClassNotFoundException {
        Connection conn = DataConnect.getConnection();
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } finally {
            DataConnect.closeConnection(conn);
        }
    }
}
