package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dataHandler.deserializers.StringToParkingSpotConverter;
import dataHandler.serializers.ParkingSpotToStringConverter;

import java.util.UUID;

public class Post {

    private UUID postId;
    @JsonSerialize(converter = ParkingSpotToStringConverter.class)
    @JsonDeserialize(converter = StringToParkingSpotConverter.class)
    private ParkingSpot parkingSpot;
    private double price;

    public Post() {
    }

    public Post(ParkingSpot parkingSpot, double price) {
        this.postId = UUID.randomUUID();
        this.parkingSpot = parkingSpot;
        this.price = price;
    }

    public Post(UUID postId, ParkingSpot parkingSpot, double price) {
        this.postId = postId;
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
