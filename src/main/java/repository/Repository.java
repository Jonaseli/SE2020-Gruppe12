package repository;

import model.Account;
import model.ParkingSpot;
import model.Post;
import model.Reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Repository implements IRepository{
    private ArrayList<Account> accounts;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<Post> posts;
    private ArrayList<Reservation> reservations;

    private Account account = new Account();
    private ParkingSpot parkingSpot = new ParkingSpot();
    private Post post = new Post();
    private Reservation reservation = new Reservation();

    private final String prepath = "src/main/resources/json/";
    private final String accountPath = prepath + "accounts.json";
    private final String parkingSpotPath = prepath + "parkingSpots.json";
    private final String postPath = prepath + "posts.json";
    private final String reservationPath = prepath + "reservations.json";

    public Repository(){
        accounts = account.readFromFile(accountPath, Account[].class);
        parkingSpots = parkingSpot.readFromFile(parkingSpotPath, ParkingSpot[].class);
        posts = post.readFromFile(postPath, Post[].class);
        reservations = reservation.readFromFile(reservationPath, Reservation[].class);
    }

    @Override
    public Account getAccount(UUID accountId) {
        for (Account account: accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Account> getAccounts() { return accounts; }

    @Override
    public void createAccount(String displayName) {
        accounts.add(new Account(displayName));
        account.writeToFile(accountPath, accounts);
    }

    @Override
    public Post getPost(UUID postId) {
        for (Post post : posts){
            if (post.getParkingSpotId().equals(postId)){
                return post;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Post> getPosts() { return posts; }

    @Override

    public void createPost(UUID parkingSpotId, String availablePeriod, double price) {
        posts.add(new Post(parkingSpotId, availablePeriod, price));
        post.writeToFile(postPath, posts);
    }

    @Override
    public ParkingSpot getParkingSpot(UUID parkingSpotId) {
        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.getParkingSpotId().equals(parkingSpotId)){
                return parkingSpot;
            }
        }
        return null;
    }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public void createParkingSpot(UUID ownerId, String type, boolean available, int width, int height, String postalCode, String streetAddress, String streetNumber, String pictureURL) {
        parkingSpots.add(new ParkingSpot(ownerId, type, available, width, height, postalCode, streetAddress, streetNumber, pictureURL));
        parkingSpot.writeToFile(parkingSpotPath, parkingSpots);
    }

    @Override
    public Reservation getReservation(UUID reservationId) { return null; }

    @Override
    public ArrayList<Reservation> getReservations() { return reservations; }

    @Override
    public void createReservation(UUID postId, UUID userId, String parkingTime) {
        reservations.add(new Reservation(postId, userId, parkingTime));
        reservation.writeToFile(reservationPath, reservations);
    }
}