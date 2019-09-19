package dao;

import java.util.List;

import models.OrderData;
import models.TourData;
import models.UserData;

public interface OrderDao {
	
	OrderData getOrderById(int orderId); 
	boolean saveOrder(OrderData orderData);
	void updateOrder(int id);
	void deleteOrder(int id);
	List<TourData> getTourByUserId(int userId);
	UserData getUserByTourCount();

}
