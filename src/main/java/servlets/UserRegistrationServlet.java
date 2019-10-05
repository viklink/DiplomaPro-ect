package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDao;
import models.UserData;

/**
 * Servlet implementation class UserRegistrationServlet
 */
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultUserDao userDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = new UserData();
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setRole(request.getParameter("role"));
		user.setEmail(request.getParameter("email"));
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.saveUser(user);
		response.sendRedirect(getServletContext().getContextPath() + "/myaccount.jsp");
	}

}
