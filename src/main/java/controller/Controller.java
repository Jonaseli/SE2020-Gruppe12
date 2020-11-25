package controller;

import io.javalin.http.Context;
import repository.IRepository;

import java.util.UUID;

public class Controller {

    private final IRepository repo;

    public Controller(IRepository repo) {
        this.repo = repo;
    }

    public void getParkingSpots(Context ctx) {
        ctx.json(repo.getParkingSpots());
    }

    public void getParkingSpot(Context ctx) {
        UUID parkingSpot = UUID.fromString(ctx.pathParam(":parking-spot-id"));
        ctx.json(repo.getParkingSpot(parkingSpot));
    }

    public void getPosts(Context ctx) {
        ctx.json(repo.getPosts());
    }

    public void getPost(Context ctx) {
        UUID postId = UUID.fromString(ctx.pathParam(":post-id"));
        ctx.json(repo.getPost(postId));
    }

    public void getAccounts(Context ctx) {
        ctx.json(repo.getAccounts());
    }

    public void getAccount(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getAccount(accountId));
    }

    public void getReservations(Context ctx) {
        ctx.json(repo.getReservations());
    }

    public void getReservation(Context ctx) {
        UUID reservationId = UUID.fromString(ctx.pathParam(":reservation-id"));
        ctx.json(repo.getReservation(reservationId));
    }

    public void getOwnedParkingSpots(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getOwnedParkingSpots(accountId));
    }

    public void getRentedParkingSpots(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        ctx.json(repo.getRentedParkingSpots(accountId));
    }

    public void createParking(Context ctx) {
        repo.createParkingSpot(ctx.formParamMap());
        System.out.println(ctx.formParamMap());
    }

    public UUID createPost(UUID parkingSpotId) {
        //Post system is not completed, this method is only used to be able to create reservations.
        return repo.createPost(parkingSpotId, 50);
    }

    public void deleteAccount(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        repo.deleteAccount(accountId);
    }

    public void deleteParkingSpot(Context ctx) {
        UUID parkingSpotId = UUID.fromString(ctx.pathParam(":parking-spot-id"));
        repo.deleteParkingSpot(parkingSpotId);
    }

    public void deletePost(Context ctx) {
        UUID postId = UUID.fromString(ctx.pathParam(":post-id"));
        repo.deletePost(postId);
    }

    public void deleteReservation(Context ctx) {
        UUID reservationId = UUID.fromString(ctx.pathParam(":reservation-id"));
        repo.deleteReservation(reservationId);
    }

    public void suspendAccount(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        repo.suspendAccount(accountId);
    }


    public void createPayment(Context ctx) {
        //Unusual implementation of post creation because it wont be completed in mvp
        UUID postId = createPost(UUID.fromString(ctx.pathParam(":parking-spot-id")));
        //AccountID is hardcoded as login system is not created
        UUID accountId = UUID.fromString("6648dfdc-9733-4a34-bfa0-e9de8c1ca78b");
        repo.createReservation(postId, accountId, "00:00", "12:00");
    }

    public void deleteReservationByParkingId(Context ctx) {
        UUID parkingSpotId = UUID.fromString(ctx.pathParam(":parking-spot-id"));
        repo.deleteReservationByParkingId(parkingSpotId);
    }
}
