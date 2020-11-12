package repository;

import model.Account;
import model.ParkingSpot;
import model.Post;
import model.Reservation;

import java.util.ArrayList;
import java.util.UUID;

public interface IRepository {

    //Accounts
    //Method for finding account object by Id (or Name?)
    Account getAccount(UUID accountId);
    //Get all accounts stored in repo
    ArrayList<Account> getAccounts();
    //Add a single account
    void createAccount(String displayName);

    //-------------------
    //Method for finding post object by ID
    Post getPost(UUID postId);
    //Get all posts stored in repo
    ArrayList<Post> getPosts();
    //Add a single post
    void createPost(UUID parkingSpotId, String availablePeriod, double price);

    //-------------------
    //Method for finding parkingSpot object by ID
    ParkingSpot getParkingSpot(UUID parkingSpotId);
    //Get all parking spots stored in repo
    ArrayList<ParkingSpot> getParkingSpots();
    //Add a single parking spot
    void createParkingSpot(UUID ownerId, String type, boolean available, int width,
                           int height, String postalCode, String streetAddress,
                           String streetNumber, String pictureURL);

    //-------------------
    //Method for finding reservation object by ID
    Reservation getReservation(UUID reservationId);
    //Get all reservations stored in repo
    ArrayList<Reservation> getReservations();
    //Add a single reservation
    void createReservation(UUID postId, UUID userId, String parkingTime);

}
