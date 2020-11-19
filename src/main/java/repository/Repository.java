package repository;

import model.*;

import java.util.*;

public class Repository implements IRepository {
    private final ArrayList<Account> accounts;
    private final ArrayList<ParkingSpot> parkingSpots;
    private final ArrayList<Post> posts;
    private final ArrayList<Reservation> reservations;

    private final Account account = new Account();
    private final ParkingSpot parkingSpot = new ParkingSpot();
    private final Post post = new Post();
    private final Reservation reservation = new Reservation();

    private final String prePath = "src/main/resources/json/";
    private final String accountPath = prePath + "accounts.json";
    private final String parkingSpotPath = prePath + "parkingSpots.json";
    private final String postPath = prePath + "posts.json";
    private final String reservationPath = prePath + "reservations.json";

    public Repository() {
        accounts = account.readFromFile(accountPath, Account[].class);
        parkingSpots = parkingSpot.readFromFile(parkingSpotPath, ParkingSpot[].class);
        posts = post.readFromFile(postPath, Post[].class);
        reservations = reservation.readFromFile(reservationPath, Reservation[].class);
    }

    @Override
    public Account getAccount(UUID accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void createAccount(String displayName) {
        accounts.add(new Account(displayName));
        account.writeToFile(accountPath, accounts);
    }

    @Override
    public Post getPost(UUID postId) {
        for (Post post : posts) {
            if (post.getParkingSpotId().equals(postId)) {
                return post;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Post> getPosts() {
        return posts;
    }

    @Override
    public void createPost(UUID parkingSpotId, double price) {
        posts.add(new Post(parkingSpotId, price));
        post.writeToFile(postPath, posts);
    }

    @Override
    public ParkingSpot getParkingSpot(UUID parkingSpotId) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getParkingSpotId().equals(parkingSpotId)) {
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
    public ArrayList<ParkingSpot> getOwnedParkingSpots(UUID accountId) {
        ArrayList<ParkingSpot> ownedParkingSpots = new ArrayList<>();
        for (ParkingSpot parking : parkingSpots) {
            if (parking.getOwnerId().equals(accountId)) {
                ownedParkingSpots.add(parking);
            }
        }
        return ownedParkingSpots;
    }

    @Override
    public ArrayList<ParkingSpot> getRentedParkingSpots(UUID accountId) {
        ArrayList<ParkingSpot> rentedParkingSpots = new ArrayList<>();
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
        boolean handicap;
        try{
            handicap = values.get("handicap").get(0) != null;
        } catch(Exception e) {
            handicap = false;
        }

        boolean chargingStation;
        try{
            chargingStation = values.get("chargingStation").get(0) != null;
        } catch(Exception e) {
            chargingStation = false;
        }

        int width = Integer.parseInt(values.get("width").get(0));
        int length = Integer.parseInt(values.get("length").get(0));
        int height = Integer.parseInt(values.get("height").get(0));
        String postalCode = values.get("postalCode").get(0);
        String city = values.get("city").get(0);
        String streetAddress = values.get("streetAddress").get(0);
        String streetNumber = values.get("streetNumber").get(0);
        String pictureURL = "";

        parkingSpots.add(new ParkingSpot(ownerId, handicap, chargingStation, available, width, length, height, postalCode, city, streetAddress, streetNumber, pictureURL));
        parkingSpot.writeToFile(parkingSpotPath, parkingSpots);
    }

    @Override
    public Reservation getReservation(UUID reservationId) {
        return null;
    }

    @Override
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public void createReservation(UUID postId, UUID userId, String startTime, String endTime) {
        reservations.add(new Reservation(postId, userId, startTime, endTime));
        reservation.writeToFile(reservationPath, reservations);
    }
}