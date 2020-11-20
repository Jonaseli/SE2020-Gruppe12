package controller;
import io.javalin.http.Context;
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

        ParkingSpot parkingSpot = repo.getParkingSpot(UUID.fromString(parkingSpotId));repo.getAccount(parkingSpot.getOwnerId());
        ctx.json(parkingSpot);
        // ctx.json(repo.getAccount(parkingSpot.getOwnerId()));
    }

    public void getPost(Context ctx) {
        String postId = ctx.pathParam(":parking-spot-id");
        Post post = repo.getPost(UUID.fromString(postId));
        ctx.json(post);
        // ctx.json(repo.getParkingSpot(post.getParkingSpotId()));
    }

    public void getAccounts(Context ctx) {
        ctx.json(repo.getAccounts());
    }

    public void getAccount(Context ctx) {
        UUID account = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getAccount(account));
    }

    public void getOwnedParkingSpots(Context ctx) {
        UUID account = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getOwnedParkingSpots(account));
    }

    public void getRentedParkingSpots(Context ctx) {
        UUID account = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getRentedParkingSpots(account));
    }

    public void createParking(Context context) {
        repo.createParkingSpot(context.formParamMap());
        System.out.println(context.formParamMap());
    }

}
