package model;

public class Post {

    private String parkingSpotID, availablePeriod;
    private double price;

    public Post(){}

    public Post(String parkingSpotID, String availablePeriod, double price){
        this.parkingSpotID = parkingSpotID;
        this.availablePeriod = availablePeriod;
        this.price = price;
    }

    public String getParkingSpotID() {
        return parkingSpotID;
    }

    public void setParkingSpotID(String parkingSpotID) {
        this.parkingSpotID = parkingSpotID;
    }

    public String getAvailablePeriod() {
        return availablePeriod;
    }

    public void setAvailablePeriod(String availablePeriod) {
        this.availablePeriod = availablePeriod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
