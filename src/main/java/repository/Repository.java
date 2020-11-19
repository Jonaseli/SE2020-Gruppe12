package repository;

import model.Account;
import model.ParkingSpot;
import model.Post;
import model.Reservation;

import java.util.*;

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
    public void createParkingSpot(Map<String, List<String>> values) {
        //TODO change ownerId and available so its not hardcoded
        UUID ownerId = UUID.fromString("6648dfdc-9733-4a34-bfa0-e9de8c1ca78b");
        boolean available = true;
        boolean handicap = Boolean.parseBoolean(values.get("handicap").get(0));
        int width = Integer.parseInt(values.get("width").get(0));
        int length = Integer.parseInt(values.get("length").get(0));
        int height = Integer.parseInt(values.get("height").get(0));
        String postalCode = values.get("postalCode").get(0);
        String poststed = values.get("poststed").get(0);
        String streetAddress = values.get("streetAddress").get(0);
        String streetNumber = values.get("streetNumber").get(0);
        String pictureURL = "";

        parkingSpots.add(new ParkingSpot(ownerId, handicap, available, width, length, height, postalCode, poststed, streetAddress, streetNumber, pictureURL));
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