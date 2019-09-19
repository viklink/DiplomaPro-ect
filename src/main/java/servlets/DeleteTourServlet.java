package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDao;
import models.TourData;

/**
 * Servlet implementation class DeleteTourServlet
 */
public class DeleteTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		tourDao = DefaultTourDao.getTourDaoInstance();
		TourData tourById = tourDao.getTourById(id);
		response.getWriter().println(tourById);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		tourDao = DefaultTourDao.getTourDaoInstance();
		tourDao.deleteTourRecord(id);
		response.getWriter().println("Record is deleted");
	}
}
