package models;

public class OrderData {
	
	private int id;
	private int userId;
	private int tourId;
	private String date;
	private int personNum;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", tourId=" + tourId + ", date=" + date
				+ ", personNum=" + personNum + "]";
	}
	
	
	

}

