package repository;

import model.Account;
import model.Post;
import model.ParkingSpot;
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

}
