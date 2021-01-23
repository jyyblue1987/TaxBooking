package services;

public class routeModel {
	private int id;
	private String to;
	private String from;
	private String fare;
	private String seat;
	private String time;

	public routeModel(){
		this.to = "";
		this.id = 0;
		this.from = "";
		this.seat = "";
		this.fare = "";
		this.time = "0:0";
	}

	public routeModel(int id, String to, String from, String fare, String seat, String time){
		this.to = to;
		this.id = id;
		this.from = from;
		this.seat = seat;
		this.fare = fare;
		this.time = time;
	}


	public String getTo(){
		return to;
	}

	public int getId(){
		return id;
	}

	public String getFrom(){
		return from;
	}

	public String getTime(){
		return time;
	}

	public String getFare(){
		return fare;
	}

	public String getSeat(){
		return seat;
	}




	public void setId(int id){
		this.id = id;
	}

	public void setTo(String to){
		this.to = to;
	}

	public void setFrom(String from){
		this.from = from;
	}

	public void setTime(String time){
		this.time = time;
	}

	public void setFare(String fare){
		this.fare = fare;
	}

	public void setSeat(String seat){
		this.seat = seat;
	}
}