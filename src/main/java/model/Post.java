package model;

import java.util.UUID;

public class Post {

    private UUID postId, parkingSpotId;
    private String availablePeriod;
    private double price;

    public Post(){}

    public Post(UUID parkingSpotId, String availablePeriod, double price){
        this.postId = UUID.randomUUID();
        this.parkingSpotId = parkingSpotId;
        this.availablePeriod = availablePeriod;
        this.price = price;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getParkingSpotId() {
        return parkingSpotId;
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
