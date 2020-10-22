import controller.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import repository.Repository;

public class Main {
    public static void main(String[] args){

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        String[] filesPaths = new String[4];
        filesPaths[0] = "parkingSpots.json";
        filesPaths[1] = "accounts.json";
        filesPaths[2] = "posts.json";
        filesPaths[3] = "reservations.json";

        app.get("/", new VueComponent("login-page"));

        //Vue
        //Får opp blank side, så vue fungerer, lurer på om det er lurt å separate repo objekter for hver import
        //dersom vi ikke får inn all info på samme side
        //app.get("/parkingSpot", new VueComponent("parkingSpots-overview"));

        Repository repo = new Repository(filesPaths);

        //api
        //Controller parkingSpotController = new Controller(repo);
        //app.get("api/parkingSpot", parkingSpotController :: getAllSpots);

    }

}
