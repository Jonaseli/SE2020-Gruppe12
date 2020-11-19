package model;

import dataHandler.JSONReadable;
import dataHandler.JSONWritable;

import java.util.UUID;

public class Reservation implements JSONReadable<Reservation>, JSONWritable<Reservation> {

    private UUID reservationId, postId, accountId;

    private String startTime;

    private String endTime;

    public Reservation() {
    }

    public Reservation(UUID postId, UUID accountId, String startTime, String endTime) {
        this.reservationId = UUID.randomUUID();
        this.postId = postId;
        this.accountId = accountId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public UUID getPostId() {
        return postId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

}
