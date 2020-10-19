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

    //-------------------
    //Method for finding post object by ID
    Post getPost(String postID);
    //Get all posts stored in repo
    ArrayList<Post> getPosts();

    //-------------------
    //Method for finding parkingSpot object by ID
    ParkingSpot getParkingSpot(String spotID);
    //Get all parking spots stored in repo
    ArrayList<ParkingSpot> getParkingSpots();

    //-------------------
    //Method for finding reservation object by ID
    Reservation getReservation(String reservationID);
    //Get all reservations stored in repo
    ArrayList<Reservation> getReservations();

}