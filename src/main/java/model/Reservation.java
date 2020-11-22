package model;

import dataHandler.JSONReadable;
import dataHandler.JSONWritable;

import java.util.UUID;

public class Reservation implements JSONReadable<Reservation>, JSONWritable<Reservation> {

    private UUID reservationId;
    private Post post;
    private Account account;
    private String startTime;
    private String endTime;

    public Reservation() {
    }

    public Reservation(Post post, Account account, String startTime, String endTime) {
        this.reservationId = UUID.randomUUID();
        this.post = post;
        this.account = account;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public Post getPost() {
        return post;
    }

    public Account getAccount() {
        return account;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

}
