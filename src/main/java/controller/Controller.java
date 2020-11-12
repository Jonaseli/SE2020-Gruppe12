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
}
