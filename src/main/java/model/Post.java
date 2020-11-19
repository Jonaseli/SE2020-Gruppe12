package model;

import dataHandler.JSONReadable;
import dataHandler.JSONWritable;

import java.util.UUID;

public class Post implements JSONReadable<Post>, JSONWritable<Post> {

    private UUID postId, parkingSpotId;
    private double price;

    public Post() {
    }

    public Post(UUID parkingSpotId, double price) {
        this.postId = UUID.randomUUID();
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
