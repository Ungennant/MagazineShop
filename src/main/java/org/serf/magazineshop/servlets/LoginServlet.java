package org.serf.magazineshop.servlets;

import org.serf.magazineshop.domain.User;
import org.serf.magazineshop.service.UserService;
import org.serf.magazineshop.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userService.getUserByEmail(email);


        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        if (user.getPassword().equals(password)) {
            request.setAttribute("userEmail", email);
            request.getRequestDispatcher("cabinet.jsp").forward(request, response);

        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
