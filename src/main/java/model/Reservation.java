package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dataHandler.deserializers.StringToAccountConverter;
import dataHandler.deserializers.StringToPostConverter;
import dataHandler.serializers.AccountToStringConverter;
import dataHandler.serializers.PostToStringConverter;

import java.util.UUID;

public class Reservation {

    private UUID reservationId;
    @JsonSerialize(converter = PostToStringConverter.class)
    @JsonDeserialize(converter = StringToPostConverter.class)
    private Post post;
    @JsonSerialize(converter = AccountToStringConverter.class)
    @JsonDeserialize(converter = StringToAccountConverter.class)
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

    public Reservation(UUID reservationId, Post post, Account account, String startTime, String endTime) {
        this.reservationId = reservationId;
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
