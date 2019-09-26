package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDao;
import impl.DefaultUserDao;
import models.TourData;

/**
 * Servlet implementation class MyAccountServlet
 */
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tourDao = DefaultTourDao.getTourDaoInstance();
		List<TourData> tours = tourDao.getAllTours();
		request.setAttribute("tours", tours);
		request.getRequestDispatcher("WEB-INF/views/myaccount.jsp").forward(request, response);
	}


}
