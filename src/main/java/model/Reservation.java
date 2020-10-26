package model;

public class Reservation implements JSONReadable<Reservation>, JSONWritable<Reservation>{

    private String reservedPostID, userID, reservationID;

    public Reservation(){}

    public Reservation(String reservedPostID, String userID, String reservationID){
        this.reservedPostID = reservedPostID;
        this.userID = userID;
        this.reservationID = reservationID;
    }

    public String getReservedPostID() {
        return reservedPostID;
    }

    public void setReservedPostID(String reservedPostID) {
        this.reservedPostID = reservedPostID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
}
