package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		HttpSession session = request.getSession();
		if (session != null) {
			userDao = DefaultUserDao.getUserDaoInstance();
			UserData user = userDao.getUserByEmail(request.getParameter("userEmail"));
			if (user != null && user.getPassword() != null
					&& user.getPassword().equals(userPassword)) {
				session.setAttribute("userEmail", userEmail);
				session.setAttribute("loggedInUser", user);
				redirectUserByRole(response, user);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
				rd.forward(request, response);
			}
		}
	}

	private void redirectUserByRole(HttpServletResponse response, UserData user) throws IOException {
		if (user != null && user.getRole().equals("admin")) {
			response.sendRedirect(getServletContext().getContextPath() + "/admin");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		userDao = DefaultUserDao.getUserDaoInstance();
		UserData user = userDao.getUserByEmail(request.getParameter("userEmail"));
		if (user != null && user.getPassword() != null && user.getPassword().equals(userPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", user);
			session.setAttribute("userEmail", userEmail);
			request.setAttribute("userEmail", userEmail);
			redirectUserByRole(response, user);

		} else {
			request.setAttribute("userNotRound", null);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
			rd.forward(request, response);
		}

	}

}
