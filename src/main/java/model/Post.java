package model;

import dataHandler.JSONReadable;
import dataHandler.JSONWritable;

import java.util.UUID;

public class Post implements JSONReadable<Post>, JSONWritable<Post> {

    private UUID postId;
    private ParkingSpot parkingSpot;
    private double price;

    public Post() {
    }

    public Post(ParkingSpot parkingSpot, double price) {
        this.postId = UUID.randomUUID();
        this.parkingSpot = parkingSpot;
        this.price = price;
    }

    public UUID getPostId() {
        return postId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
