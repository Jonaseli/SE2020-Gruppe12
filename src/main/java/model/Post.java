package model;

import java.util.ArrayList;
import java.util.UUID;

public class Post implements JSONReadable<Post>, JSONWritable<Post>{
    
    private UUID postId, parkingSpotId;

    // [["15:00", "18:00"],["25.10 12:14", "25.10 12:50"]]
    private ArrayList<Time> reservations;
    private double price;

    public Post(){}

    public Post(UUID parkingSpotId, ArrayList<Time> reservations, double price){
        this.postId = UUID.randomUUID();
        this.parkingSpotId = parkingSpotId;
        this.reservations = new ArrayList<>();
        this.price = price;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getParkingSpotId() {
        return parkingSpotId;
    }

    public ArrayList<Time> getReservationTimes() {
        return reservations;
    }

    public void addReservationTime(String startTime, String endTime) {
        reservations.add(new Time(startTime, endTime));
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
