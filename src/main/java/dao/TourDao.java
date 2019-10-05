package dao;

import java.util.List;

import models.TourData;

public interface TourDao {
	TourData getTourById(int id);
	TourData getTourByName(String name);
	List<TourData> getTourByPrice(double price);
	boolean saveTour(TourData tour);
	void updateTourRecord(TourData tour);
	void deleteTour(int id);
	List<TourData> getAllTours();

}
