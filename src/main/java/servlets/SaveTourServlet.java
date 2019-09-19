package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDao;
import models.TourData;

/**
 * Servlet implementation class SaveTourServlet
 */
public class SaveTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TourData tour = new TourData();
		tour.setId(Integer.valueOf(request.getParameter("id")));
		tour.setName(request.getParameter("name"));
		tour.setPrice(Double.valueOf(request.getParameter("price")));
		tourDao = DefaultTourDao.getTourDaoInstance();
		tourDao.saveTour(tour);
		response.getWriter().println(tour);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TourData tour = new TourData();
		tour.setId(Integer.valueOf(request.getParameter("id")));
		tour.setName(request.getParameter("name"));
		tour.setPrice(Double.valueOf(request.getParameter("price")));
		tourDao = DefaultTourDao.getTourDaoInstance();
		tourDao.saveTour(tour);
		response.getWriter().println(tour);
	}

}
