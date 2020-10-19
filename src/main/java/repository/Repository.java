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

        //Some code to test if object were created, remove later.
        System.out.println(accounts);
        System.out.println(accounts.get(0).getAccountID());

        System.out.println(parkingSpots);
        System.out.println(parkingSpots.get(0).getOwner());

        System.out.println(posts);
        System.out.println(posts.get(0).getParkingSpotID());

        System.out.println(reservations);
        System.out.println(reservations.get(0).getReservationID());
    }

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

    //TODO method for writing to file.

    @Override
    public Account getAccount(String accountID) {
        return null;
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return null;
    }

    @Override
    public Post getPost(String postID) {
        return null;
    }

    @Override
    public ArrayList<Post> getPosts() {
        return null;
    }

    @Override
    public ParkingSpot getParkingSpot(String spotID) { return null; }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public Reservation getReservation(String reservationID) {
        return null;
    }

    @Override
    public ArrayList<Reservation> getReservations() {
        return null;
    }
}
