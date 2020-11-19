package controller;
import io.javalin.http.Context;
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
        ctx.json(repo.getParkingSpot(UUID.fromString(parkingSpotId)));
    }

    public void getPost(Context ctx) {
        String postId = ctx.pathParam(":parking-spot-id");
        ctx.json(repo.getPost(UUID.fromString(postId)));
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
