package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDao;
import models.TourData;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tourDao = DefaultTourDao.getTourDaoInstance();
		List<TourData> tours = tourDao.getAllTours();
		request.setAttribute("tours", tours);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/admin.jsp");
		rd.forward(request, response); 
	}

}
