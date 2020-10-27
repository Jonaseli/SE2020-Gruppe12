package repository;

import model.Account;
import model.ParkingSpot;
import model.Post;
import model.Reservation;

import java.util.ArrayList;

public interface IRepository {

    //Accounts
    //Method for finding account object by ID (or Name?)
    Account getAccount(String accountID);
    //Get all accounts stored in repo
    ArrayList<Account> getAccounts();
    //Add a single account
    void createAccount(String accountID, String displayName, boolean suspended);

    //-------------------
    //Method for finding post object by ID
    Post getPost(String postID);
    //Get all posts stored in repo
    ArrayList<Post> getPosts();
    //Add a single post
    void createPost(String parkingSpotID, String availablePeriod, double price);

    //-------------------
    //Method for finding parkingSpot object by ID
    ParkingSpot getParkingSpot(String spotID);
    //Get all parking spots stored in repo
    ArrayList<ParkingSpot> getParkingSpots();
    //Add a single parking spot
    void createParkingSpot(String owner, String type, boolean available, int width,
                           int height, String postalCode, String streetAddress,
                           String streetNumber, String pictureURL);

    //-------------------
    //Method for finding reservation object by ID
    Reservation getReservation(String reservationID);
    //Get all reservations stored in repo
    ArrayList<Reservation> getReservations();
    //Add a single reservation
    void createReservation(String userId, String reservationId);

}
