package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.DefaultOrderDao;
import impl.DefaultTourDao;
import models.TourData;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("loggedInUser");
		tourDao = DefaultTourDao.getTourDaoInstance();
		List<TourData> tours = tourDao.getAllTours();
		request.setAttribute("tours", tours);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/order.jsp");
		rd.forward(request, response); 
	}

}
