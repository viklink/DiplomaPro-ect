package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/admin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TourData tour = new TourData();
		//tour.setId(Integer.valueOf(request.getParameter("id")));
		tour.setName(request.getParameter("name"));
		tour.setPrice(Double.valueOf(request.getParameter("price")));
		tour.setDescription(request.getParameter("description"));
		tourDao = DefaultTourDao.getTourDaoInstance();
		tourDao.saveTour(tour);
		request.getRequestDispatcher("WEB-INF/views/success.jsp").forward(request, response);
	}

}
