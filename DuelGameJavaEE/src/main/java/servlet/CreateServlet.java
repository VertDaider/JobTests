package servlet;

import duelGame.User;
import duelGame.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            if (name != null && password != null) {
                if (!name.equals("") && !password.equals("")) {
                    if (!UserDB.isExist(name)) {
                        User user = new User(name, password);
                        UserDB.insert(user);
                    } else {
                        doGet(request, response);
                    }
                } else {
                    doGet(request, response);
                }
            }

            response.sendRedirect(request.getContextPath() + "/list");
        } catch (Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}
