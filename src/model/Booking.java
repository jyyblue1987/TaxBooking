package model;

public class Booking {
    public String name;
    public String phone;
    public String email;
    public String card_number;
    public String card_code;
    public String departure;
    public String return_date;
    public String bus_id;
    public String bus_name;
    public String capacity;
    public Booking(String name, String phone, String email, String card_number, String card_code, String departure, String return_date, String bus_id, String bus_name, String capacity) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.card_number = card_number;
        this.card_code = card_code;
        this.departure = departure;
        this.return_date = return_date;
        this.bus_id = bus_id;
        this.bus_name = bus_name;
        this.capacity = capacity;
    }

    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getDeparture(){
        return departure;
    }
    public String getReturn_date(){
        return return_date;
    }
    public String getBus_id(){
        return bus_id;
    }
    public String getBus_name(){
        return bus_name;
    }
    public String getCapacity(){
        return capacity;
    }

}
