package controller;
import io.javalin.http.Context;
import repository.IRepository;
import io.javalin.http.NotFoundResponse;
public class Controller {

    private IRepository repo;

    public Controller(IRepository repo){
        this.repo = repo;
    }

    public void getParkingSpots(Context ctx){
        ctx.json(repo.getParkingSpots());
    }

    public void getParking(Context ctx){
        String parkingSpot = ctx.pathParam(":parking-spot-id");
        ctx.json(repo.getParkingSpot(parkingSpot));
    }
}
