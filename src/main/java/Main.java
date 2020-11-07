import controller.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import repository.Repository;

public class Main {
    public static void main(String[] args){

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        app.get("/", new VueComponent("login-page"));
        app.get("/parking-spot", new VueComponent("parking-spots-overview"));
        app.get("/parking-spot/:parking-spot-id", new VueComponent("parking-spot-detail"));
        app.get("/parking-spot/:parking-spot-id/payment", new VueComponent("payment-page"));

        Repository repo = new Repository();

        //api
        Controller parkingSpotController = new Controller(repo);
        app.get("api/parking-spot", parkingSpotController :: getParkingSpots);
        app.get("api/parking-spot/:parking-spot-id", parkingSpotController :: getParking);

        app.post("/api/parking-spot/:parking-spot-id/payment", ctx -> {
            //parkingSpotController.createPayment(ctx);
            ctx.redirect("/parking-spot");
        });

    }

}
