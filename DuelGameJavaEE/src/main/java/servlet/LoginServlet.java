package servlet;

import duelGame.User;
import duelGame.UserDB;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("name", request.getParameter("name"));
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            User tempUser = new User(name, password);

                if (UserDB.validate(tempUser)) {
                    request.getSession().setAttribute("user", tempUser);
                    response.sendRedirect(request.getContextPath() + "/main");
                } else {
                    doGet(request, response);
                }

        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
    }
}
