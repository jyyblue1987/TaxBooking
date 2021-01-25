package model;

public class Booking {
    public String name;
    public String phone;
    public String email;
    public String address;
    public String city;
    public String card_number;
    public String card_code;
    public String departure;
    public String return_date;
    public String bus_id;
    public Booking(String name, String phone, String email, String address, String city, String card_number, String card_code, String departure, String return_date, String bus_id) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.card_number = card_number;
        this.card_code = card_code;
        this.departure = departure;
        this.return_date = return_date;
        this.bus_id = bus_id;
    }

}
