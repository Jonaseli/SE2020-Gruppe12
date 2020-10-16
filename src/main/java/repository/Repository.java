package repository;

import java.io.File;

public class Repository implements IRepository{
    private File file;
    //TODO create these classes
    private ArrayList<Account> accounts;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<Post> posts;

    public Repository(File file){
        this.file = file;
        //input file in constructor
        //method for reading file here.
    }

    //TODO method for reading from file.
    //TODO method for writing to file.
    //Need to know how the JSON file looks before creating these.

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
    public ParkingSpot getParkingSpot(String spotID) {
        return null;
    }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return null;
    }
}
