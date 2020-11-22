package model;

import java.util.UUID;

public class Post {

    private UUID postId;
    private UUID parkingSpot;
    private double price;

    public Post() {
    }

    public Post(UUID parkingSpot, double price) {
        this.postId = UUID.randomUUID();
        this.parkingSpot = parkingSpot;
        this.price = price;
    }

    public Post(UUID postId, UUID parkingSpot, double price) {
        this.postId = postId;
        this.parkingSpot = parkingSpot;
        this.price = price;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getParkingSpot() {
        return parkingSpot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
