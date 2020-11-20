import controller.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import repository.Repository;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7000);
        app.config.enableWebjars();

        app.get("/", new VueComponent("login-page"));
        app.get("/parking-spot", new VueComponent("parking-spots-overview"));
        app.get("/parking-spot/:parking-spot-id", new VueComponent("parking-spot-detail"));
        app.get("/parking-spot/:parking-spot-id/posts/:post-id", new VueComponent("parking-spot-detail"));
        app.get("/parking-spot/:parking-spot-id/payment", new VueComponent("payment-page"));

        app.get("/account", new VueComponent("accounts-overview"));
        app.get("/account/:account-id/my-parking-spots", new VueComponent("my-parking-spots"));
        app.get("/account/:account-id/my-parking-spots/create-parking", new VueComponent("parking-create"));

        app.get("/admin-page", new VueComponent("admin-page"));

        Repository repo = new Repository();

        //api
        Controller parkingSpotController = new Controller(repo);
        app.get("api/parking-spot", parkingSpotController::getParkingSpots);
        app.get("api/parking-spot/:parking-spot-id", parkingSpotController::getParkingSpot);
        app.get("api/parking-spot/:parking-spot-id/posts/:post-id", parkingSpotController::getPost);

        app.get("api/account", parkingSpotController::getAccounts);
        app.get("api/account/:account-id", parkingSpotController::getAccount);
        app.get("api/account/:account-id/my-parking-spots/owned-parking-spots", parkingSpotController::getOwnedParkingSpots);
        app.get("api/account/:account-id/my-parking-spots/rented-parking-spots", parkingSpotController::getRentedParkingSpots);

        app.get("api/post", parkingSpotController::getPosts);

        app.get("api/reservation", parkingSpotController::getReservations);

        app.post("/api/parking-spot/:parking-spot-id/payment", ctx -> {
            //parkingSpotController.createPayment(ctx);
            ctx.redirect("/parking-spot");
        });

        //Admin controls
        app.get("/api/admin/account/suspend/:account-id", ctx -> {
            parkingSpotController.suspendAccount(ctx);
            ctx.redirect("/admin-page");
        });

        app.get("/api/admin/account/:account-id", ctx -> {
            parkingSpotController.deleteAccount(ctx);
            ctx.redirect("/admin-page");
        });

        app.get("/api/admin/parking-spot/:parking-spot-id", ctx -> {
            parkingSpotController.deleteParkingSpot(ctx);
            ctx.redirect("/admin-page");
        });

        app.get("/api/admin/post/:post-id", ctx -> {
            parkingSpotController.deletePost(ctx);
            ctx.redirect("/admin-page");
        });

        app.get("/api/admin/reservation/:reservation-id", ctx -> {
            parkingSpotController.deleteReservation(ctx);
            ctx.redirect("/admin-page");
        });

        app.post("/api/account/:account-id/my-parking-spots/create-parking", ctx -> {
            parkingSpotController.createParking(ctx);
            ctx.redirect("/parking-spot");
        });
    }
}
