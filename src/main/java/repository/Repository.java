package repository;

import dataHandler.JsonParser;
import model.*;

import java.util.*;

public class Repository implements IRepository {
    public static final String ACCOUNTS_PATH = "src/main/resources/json/accounts.json";
    public static final String PARKING_SPOTS_PATH = "src/main/resources/json/parkingSpots.json";
    public static final String POSTS_PATH = "src/main/resources/json/posts.json";
    public static final String RESERVATIONS_PATH = "src/main/resources/json/reservations.json";

    public static final ArrayList<Account> accounts = JsonParser.readFromFile(ACCOUNTS_PATH, Account.class);
    public static final ArrayList<ParkingSpot> parkingSpots = JsonParser.readFromFile(PARKING_SPOTS_PATH, ParkingSpot.class);
    public static final ArrayList<Post> posts = JsonParser.readFromFile(POSTS_PATH, Post.class);
    public static final ArrayList<Reservation> reservations = JsonParser.readFromFile(RESERVATIONS_PATH, Reservation.class);

    public Repository() {
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
        JsonParser.writeToFile(ACCOUNTS_PATH, accounts);
    }

    @Override
    public Post getPost(UUID postId) {
        for (Post post : posts) {
            if (post.getPostId().equals(postId)) {
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
        JsonParser.writeToFile(POSTS_PATH, posts);
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
    public ArrayList<ParkingSpot> getOwnedParkingSpots(UUID account) {
        ArrayList<ParkingSpot> ownedParkingSpots = new ArrayList<>();
        for (ParkingSpot parking : parkingSpots) {
            if (parking.getOwner().equals(account)) {
                ownedParkingSpots.add(parking);
            }
        }
        return ownedParkingSpots;
    }

    @Override
    public ArrayList<ParkingSpot> getRentedParkingSpots(UUID account) {
        ArrayList<ParkingSpot> rentedParkingSpots = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getAccountId().equals(account)) {
                UUID postId = reservation.getPostId();
                for (Post post : posts) {
                    if (post.getPostId().equals(postId)) {
                        rentedParkingSpots.add(getParkingSpot(post.getParkingSpot()));
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
        try {
            handicap = values.get("handicap").get(0) != null;
        } catch (Exception e) {
            handicap = false;
        }

        boolean chargingStation;
        try {
            chargingStation = values.get("chargingStation").get(0) != null;
        } catch (Exception e) {
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
        JsonParser.writeToFile(PARKING_SPOTS_PATH, parkingSpots);
    }

    @Override
    public Reservation getReservation(UUID reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public void createReservation(UUID postId, UUID userId, String startTime, String endTime) {
        reservations.add(new Reservation(postId, userId, startTime, endTime));
        JsonParser.writeToFile(RESERVATIONS_PATH, reservations);
    }

    @Override
    public void deleteAccount(UUID accountId) {
        accounts.remove(getAccount(accountId));
        JsonParser.writeToFile(ACCOUNTS_PATH, accounts);
    }

    @Override
    public void deleteReservation(UUID reservationId) {
        reservations.remove(getReservation(reservationId));
        JsonParser.writeToFile(RESERVATIONS_PATH, reservations);
    }

    @Override
    public void deletePost(UUID postId) {
        posts.remove(getPost(postId));
        JsonParser.writeToFile(POSTS_PATH, posts);
    }

    @Override
    public void deleteParkingSpot(UUID parkingSpotId) {
        parkingSpots.remove(getParkingSpot(parkingSpotId));
        JsonParser.writeToFile(PARKING_SPOTS_PATH, parkingSpots);
    }

    @Override
    public void suspendAccount(UUID accountId) {
        //Swap boolean value of suspended
        getAccount(accountId).setSuspended(!getAccount(accountId).isSuspended());
        JsonParser.writeToFile(ACCOUNTS_PATH, accounts);
    }
}