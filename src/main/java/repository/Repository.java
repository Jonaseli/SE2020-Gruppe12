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
    public Account getAccount(UUID accountId) {
        for (Account account : accounts){
            if (account.getAccountId().equals(accountId)){
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
    public Post getPost(String postID) { return null; }

    @Override
    public ArrayList<Post> getPosts() { return posts; }

    @Override

    public void createPost(UUID parkingSpotId, String availablePeriod, double price) {
        posts.add(new Post(parkingSpotId, availablePeriod, price));
        post.writeToFile(postPath, posts);
    }

    @Override
    public ParkingSpot getParkingSpot(UUID spotId) {
        for (ParkingSpot spot : parkingSpots){
            if (spot.getParkingSpotId().equals(spotId)){
                return spot;
            }
        }
        return null;
    }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public ArrayList<ParkingSpot> getOwnedParkingSpots(UUID accountId) {
        ArrayList<ParkingSpot> ownedParkingSpots = new ArrayList<ParkingSpot>();
        for (ParkingSpot parking : parkingSpots){
            if(parking.getOwnerId().equals(accountId)){
                ownedParkingSpots.add(parking);
            }
        }
        return ownedParkingSpots;
    }

    @Override
    public ArrayList<ParkingSpot> getRentedParkingSpots(UUID accountId) {
        ArrayList<ParkingSpot> rentedParkingSpots = new ArrayList<ParkingSpot>();
        for (Reservation reservation : reservations) {
            if (reservation.getAccountId().equals(accountId)) {
                UUID posId = reservation.getPostId();
                for (Post post : posts) {
                    if (post.getPostId().equals(posId)) {
                        rentedParkingSpots.add(getParkingSpot(post.getParkingSpotId()));
                    }
                }
            }
        }
        return rentedParkingSpots;
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