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
import java.util.UUID;

public class Repository implements IRepository{
    private String[] filePaths;
    private ArrayList<Account> accounts;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<Post> posts;
    private ArrayList<Reservation> reservations;

    public Repository(String[] filePaths){
        this.filePaths = filePaths;
        parkingSpots = readParkingSpotValues();
        accounts = readAccountValues();
        posts = readPostValues();
        reservations = readReservationValues();
    }

    //Parking spots read/write

    private ArrayList<ParkingSpot> readParkingSpotValues(){
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            ParkingSpot[] parkingSpotsArray = (objectMapper.readValue(new File(filePaths[0]), ParkingSpot[].class));
            parkingSpots = Arrays.asList(parkingSpotsArray);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
        return new ArrayList<>(parkingSpots);
    }

    private void writeParkingSpotValues() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePaths[0]), parkingSpots);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    //Accounts read/write

    private ArrayList<Account> readAccountValues(){
        List<Account> accounts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Account[] accountsArray = (objectMapper.readValue(new File(filePaths[1]), Account[].class));
            accounts = Arrays.asList(accountsArray);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
        return new ArrayList<>(accounts);
    }

    private void writeAccountValues() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePaths[1]), accounts);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    //Posts read/write

    private ArrayList<Post> readPostValues(){
        List<Post> posts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Post[] postsArray = (objectMapper.readValue(new File(filePaths[2]), Post[].class));
            posts = Arrays.asList(postsArray);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
        return new ArrayList<>(posts);
    }

    private void writePostValues() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePaths[2]), posts);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    //Reservation read/write

    private ArrayList<Reservation> readReservationValues(){
        List<Reservation> reservations = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Reservation[] reservationsArray = (objectMapper.readValue(new File(filePaths[3]), Reservation[].class));
            reservations = Arrays.asList(reservationsArray);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
        return new ArrayList<>(reservations);
    }

    private void writeReservationValues() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePaths[3]), reservations);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public Account getAccount(UUID accountId) { return null; }

    @Override
    public ArrayList<Account> getAccounts() { return accounts; }

    @Override
    public void createAccount(String displayName) {
        accounts.add(new Account(displayName));
        writeAccountValues();
    }

    @Override
    public Post getPost(String postID) { return null; }

    @Override
    public ArrayList<Post> getPosts() { return posts; }

    @Override
    public void createPost(UUID parkingSpotId, String availablePeriod, double price) {
        posts.add(new Post(parkingSpotId, availablePeriod, price));
        writePostValues();
    }

    @Override
    public ParkingSpot getParkingSpot(UUID spotId) { return null; }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public void createParkingSpot(UUID ownerId, String type, boolean available, int width, int height, String postalCode, String streetAddress, String streetNumber, String pictureURL) {
        parkingSpots.add(new ParkingSpot(ownerId, type, available, width, height, postalCode, streetAddress, streetNumber, pictureURL));
        writeParkingSpotValues();
    }

    @Override
    public Reservation getReservation(UUID reservationId) { return null; }

    @Override
    public ArrayList<Reservation> getReservations() { return reservations; }

    @Override
    public void createReservation(UUID postId, String userId, String parkingTime) {
        reservations.add(new Reservation(postId, userId, parkingTime));
        writeReservationValues();
    }
}