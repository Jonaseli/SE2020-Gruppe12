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

    public void getParking(Context ctx){
        System.out.println(ctx.pathParam(":parking-spot-id"));
        UUID parkingSpot = UUID.fromString(ctx.pathParam(":parking-spot-id"));
        ctx.json(repo.getParkingSpot(parkingSpot));
    }
}
