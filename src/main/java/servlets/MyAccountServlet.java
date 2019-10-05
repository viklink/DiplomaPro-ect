package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.DefaultOrderDao;
import impl.DefaultTourDao;
import impl.DefaultUserDao;
import models.TourData;
import models.UserData;

/**
 * Servlet implementation class MyAccountServlet
 */
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultUserDao userDao;
	private DefaultOrderDao orderDao;
	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDao = DefaultOrderDao.getOrderDaoInstance();
		userDao = DefaultUserDao.getUserDaoInstance();
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userEmail");
		List<TourData> tours = orderDao.getTourByUserEmail(userEmail);
		request.setAttribute("myTours", tours);
		request.getRequestDispatcher("WEB-INF/views/myaccount.jsp").forward(request, response);
	}


}
