package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Account;
import model.ParkingSpot;
import model.Post;
import model.Reservation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository implements IRepository{
    private ArrayList<Account> accounts;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<Post> posts;
    private ArrayList<Reservation> reservations;

    private Account account = new Account();
    private ParkingSpot parkingSpot = new ParkingSpot();
    private Post post = new Post();
    private Reservation reservation = new Reservation();

    private final String accountPath = "accounts.json";
    private final String parkingSpotPath = "parkingSpots.json";
    private final String postPath = "posts.json";
    private final String reservationPath = "reservations.json";

    public Repository(){
        accounts = account.readFromFile(accountPath, Account[].class);
        parkingSpots = parkingSpot.readFromFile(parkingSpotPath, ParkingSpot[].class);
        posts = post.readFromFile(postPath, Post[].class);
        reservations = reservation.readFromFile(reservationPath, Reservation[].class);
    }

    @Override
    public Account getAccount(String accountID) { return null; }

    @Override
    public ArrayList<Account> getAccounts() { return accounts; }

    @Override
    public void createAccount(String accountID, String displayName, boolean suspended) {
        accounts.add(new Account(accountID, displayName, suspended));
        account.writeToFile(accountPath, accounts);
    }

    @Override
    public Post getPost(String postID) { return null; }

    @Override
    public ArrayList<Post> getPosts() { return posts; }

    @Override
    public void createPost(String parkingSpotID, String availablePeriod, double price) {
        posts.add(new Post(parkingSpotID, availablePeriod, price));
        post.writeToFile(postPath, posts);
    }

    @Override
    public ParkingSpot getParkingSpot(String spotID) { return null; }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public void createParkingSpot(String owner, String type, boolean available, int width, int height, String postalCode, String streetAddress, String streetNumber, String pictureURL) {
        parkingSpots.add(new ParkingSpot(owner, type, available, width, height, postalCode, streetAddress, streetNumber, pictureURL));
        parkingSpot.writeToFile(parkingSpotPath, parkingSpots);
    }

    @Override
    public Reservation getReservation(String reservationID) { return null; }

    @Override
    public ArrayList<Reservation> getReservations() { return reservations; }

    @Override
    public void createReservation(String reservedPostID, String userID, String reservationID) {
        reservations.add(new Reservation(reservedPostID, userID, reservationID));
        reservation.writeToFile(reservationPath, reservations);
    }
}
