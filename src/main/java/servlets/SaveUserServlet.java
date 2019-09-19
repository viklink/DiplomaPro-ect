package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultUserDao;
import models.UserData;

/**
 * Servlet implementation class SaveUserServlet
 */
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultUserDao userDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = new UserData();
		user.setId(Integer.valueOf(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setRoleId(Integer.valueOf(request.getParameter("roleId")));
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.saveUser(user);
		response.getWriter().println(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData user = new UserData();
		user.setId(Integer.valueOf(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setRoleId(Integer.valueOf(request.getParameter("roleId")));
		userDao = DefaultUserDao.getUserDaoInstance();
		userDao.saveUser(user);
		response.getWriter().println(user);
	}

}
