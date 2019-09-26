package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.DefaultUserDao;
import models.UserData;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultUserDao userDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		HttpSession session = request.getSession(false);
		if (session != null) {
			userDao = DefaultUserDao.getUserDaoInstance();
			UserData user = userDao.getUserByEmail(request.getParameter("userEmail"));
			if (user != null && user.getPassword() != null
					&& user.getPassword().equals(userPassword)) {
				session.setAttribute("userEmail", userEmail);
				session.setAttribute("loggedInUser", user);
				redirectUserByRoleId(response, user);

			} else {
				request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			}
		}
	}

	private void redirectUserByRoleId(HttpServletResponse response, UserData user) throws IOException {
		if (user != null && user.getRoleId() == 2) {
			response.sendRedirect(getServletContext().getContextPath() + "/admin");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		/*
		 * if(userEmail.equals("asd@asd")) { UserData userData = new UserData();
		 * userData.setRoleId(2); HttpSession session = request.getSession();
		 * session.setAttribute("userEmail", userEmail);
		 * session.setAttribute("loggedInUser", userData);
		 * response.sendRedirect(getServletContext().getContextPath() + "/myaccount"); }
		 */
		userDao = DefaultUserDao.getUserDaoInstance();
		UserData user = userDao.getUserByEmail(request.getParameter("userEmail"));
		if (user != null && user.getPassword() != null && user.getPassword().equals(userPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", user);
			redirectUserByRoleId(response, user);

		} else {
			request.setAttribute("userNotRound", null);
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}
