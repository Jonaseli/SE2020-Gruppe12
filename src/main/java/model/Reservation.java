package model;

import java.util.UUID;

public class Reservation {

    private UUID reservationId, postId;
    private String userId, parkingTime;

    public Reservation(){}

    public Reservation(UUID postId, String userId, String parkingTime){
        this.reservationId = UUID.randomUUID();
        this.postId = postId;
        this.userId = userId;
        this.parkingTime = parkingTime;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public UUID getReservedPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getParkingTime() {
        return parkingTime;
    }

}
