package org.serf.magazineshop.servlets;

import org.serf.magazineshop.domain.User;
import org.serf.magazineshop.domain.UserRole;
import org.serf.magazineshop.service.UserService;
import org.serf.magazineshop.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
            userService.create(new User(email, firstName, lastName, UserRole.USER.toString(), password));
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
}
