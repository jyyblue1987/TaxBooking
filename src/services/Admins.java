package services;

public class Admins {
	private int id;
	private String name;
	private String email;
	private String address;

	public Admins(){
		this.name = ""; 
		this.id = 0; 
		this.email = "";
		this.address = ""; 
	}

	public Admins(int id,String name,String email, String address ){
		this.name = name; 
		this.id = id; 
		this.email = email;
		this.address = address; 
	}


	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getAddress(){
		return address;
	}


	public void setName(String name){
		this.name = name; 
	}

	public void setId(int id){
		this.id = id; 
	}

	public void setPhone(String phone){
		this.email = email;
	}

	public void setAddress(String address){
		this.address = address; 
	}
}
