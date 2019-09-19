package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDao;
import models.TourData;

/**
 * Servlet implementation class TourByPriceServlet
 */
public class TourByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double maxPrice = Double.valueOf(request.getParameter("maxPrice"));
		tourDao = DefaultTourDao.getTourDaoInstance();
		List<TourData> tourByPrice = tourDao.getTourByPrice(maxPrice);
		response.getWriter().println(tourByPrice);
	}

}
