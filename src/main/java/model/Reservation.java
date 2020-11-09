package model;

import java.util.UUID;

public class Reservation implements JSONReadable<Reservation>, JSONWritable<Reservation>{
    
    private UUID reservationId, postId, accountId;
    private String parkingTime;

    public Reservation(){}

    public Reservation(UUID postId, UUID accountId, String parkingTime){
        this.reservationId = UUID.randomUUID();
        this.postId = postId;
        this.accountId = accountId;
        this.parkingTime = parkingTime;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getReservedPostId() {
        return postId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getParkingTime() {
        return parkingTime;
    }

}
