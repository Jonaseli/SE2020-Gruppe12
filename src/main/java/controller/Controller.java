package controller;
import io.javalin.http.Context;
import model.Account;
import model.ParkingSpot;
import model.Post;
import repository.IRepository;

import java.util.UUID;

public class Controller {

    private IRepository repo;

    public Controller(IRepository repo){
        this.repo = repo;
    }

    public void getParkingSpots(Context ctx){
        ctx.json(repo.getParkingSpots());
    }

    public void getParkingSpot(Context ctx){
        String parkingSpotId = ctx.pathParam(":parking-spot-id");
        ParkingSpot parkingSpot = repo.getParkingSpot(UUID.fromString(parkingSpotId));
        ctx.json(parkingSpot);
    }

    public void getPost(Context ctx) {
        String postId = ctx.pathParam(":parking-spot-id");
        Post post = repo.getPost(UUID.fromString(postId));
        ctx.json(post);
    }

    public void getAccounts(Context ctx) {
        ctx.json(repo.getAccounts());
    }

    public void getAccount(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getAccount(accountId));
    }

    public void getOwnedParkingSpots(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        Account account = repo.getAccount(accountId);
        ctx.json(repo.getOwnedParkingSpots(account));
    }

    public void getRentedParkingSpots(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        Account account = repo.getAccount(accountId);
        ctx.json(repo.getRentedParkingSpots(account));
    }

    public void createParking(Context context) {
        repo.createParkingSpot(context.formParamMap());
        System.out.println(context.formParamMap());
    }

}
