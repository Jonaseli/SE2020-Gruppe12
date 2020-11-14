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

        app.get("/account", new VueComponent("accounts-overview"));
        app.get("/account/:account-id/my-parking-spots", new VueComponent("my-parking-spots"));
        app.get("/account/:account-id/my-parking-spots/create-parking", new VueComponent("parking-create"));

        Repository repo = new Repository();

        //api
        Controller parkingSpotController = new Controller(repo);
        app.get("api/parking-spot", parkingSpotController :: getParkingSpots);
        app.get("api/parking-spot/:parking-spot-id", parkingSpotController :: getParking);

        app.get("api/account", parkingSpotController :: getAccounts);
        app.get("api/account/:account-id", parkingSpotController :: getAccount);
        app.get("api/account/:account-id/my-parking-spots/owned-parking-spots", parkingSpotController :: getOwnedParkingSpots);
        app.get("api/account/:account-id/my-parking-spots/rented-parking-spots", parkingSpotController :: getRentedParkingSpots);

        app.post("/api/parking-spot/:parking-spot-id/payment", ctx -> {
            //parkingSpotController.createPayment(ctx);
            ctx.redirect("/parking-spot");
        });

        app.post("/api/account/:account-id/my-parking-spots/create-parking", ctx -> {
            //parkingSpotController.createPayment(ctx);
            ctx.redirect("/parking-spot");
        });
    }
}
