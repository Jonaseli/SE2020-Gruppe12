package model;

import java.util.UUID;

public class Reservation {

    private UUID reservationId;
    private UUID postId;
    private UUID accountId;
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

    public Reservation(UUID reservationId, UUID postId, UUID accountId, String startTime, String endTime) {
        this.reservationId = reservationId;
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
