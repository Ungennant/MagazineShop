package org.serf.magazineshop.servlets;

import org.serf.magazineshop.domain.User;
import org.serf.magazineshop.domain.UserRole;
import org.serf.magazineshop.service.UserService;
import org.serf.magazineshop.service.impl.UserServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserService userService = UserServiceImpl.getUserService();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String password = request.getParameter("password");

      if(!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()){
          userService.create(new User(email, firstName,lastName, UserRole.USER.toString(),password));
      }
      request.getRequestDispatcher("cabinet.jsp").forward(request, response);
  }
}
