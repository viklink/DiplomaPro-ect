package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDao;
import models.UserData;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultUserDao userDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		userDao = DefaultUserDao.getUserDaoInstance();
		UserData userById = userDao.getUserById(id);
		response.getWriter().println(userById);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		userDao = DefaultUserDao.getUserDaoInstance();
		UserData user = userDao.getUserById(id);
		user.setId(id);
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setRoleId(Integer.valueOf(request.getParameter("roleId")));
		userDao.updateUserRecord(id);
		response.getWriter().println(user);
	}

}
