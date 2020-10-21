package controller;
import io.javalin.http.Context;
import repository.IRepository;
public class Controller {

    private IRepository repo;

    public Controller(IRepository repo){
        this.repo = repo;
    }

    public void getAllSpots(Context ctx){
        ctx.json(repo.getParkingSpots());
    }
}
