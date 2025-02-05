package problems.car_rental_system.model;

public class Location {
    String address;
    int zipCode;
    String city;
    String state;
    String country;

    public Location(String address, int zipCode, String city, String state, String country) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
