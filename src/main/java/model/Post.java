package model;

import java.util.UUID;

public class Post {

    private UUID postId;
    private UUID parkingSpotId;
    private double price;

    public Post() {
    }

    public Post(UUID parkingSpotId, double price) {
        this.postId = UUID.randomUUID();
        this.parkingSpotId = parkingSpotId;
        this.price = price;
    }

    public Post(UUID postId, UUID parkingSpotId, double price) {
        this.postId = postId;
        this.parkingSpotId = parkingSpotId;
        this.price = price;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getParkingSpotId() {
        return parkingSpotId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
