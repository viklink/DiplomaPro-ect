package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDao;
import models.UserData;

public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultUserDao userDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = new UserData();
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setRoleId(Integer.valueOf(request.getParameter("roleId")));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.saveUser(user);
		//response.sendRedirect(getServletContext().getContextPath() + "/successRegistration.jsp");
		request.getRequestDispatcher("WEB-INF/views/successRegistration.jsp").forward(request, response);
	}

}
