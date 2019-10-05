package dao;

import java.util.List;

import models.OrderData;
import models.TourData;
import models.UserData;

public interface OrderDao {
	
	OrderData getOrderById(int id); 
	boolean saveOrder(OrderData order);
	void updateOrder(OrderData order);
	void deleteOrder(int id);
	List<TourData> getTourByUserEmail(String email);
	UserData getUserByTourCount();

}
