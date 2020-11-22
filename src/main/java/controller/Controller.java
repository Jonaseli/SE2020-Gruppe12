package controller;
import io.javalin.http.Context;
import model.Account;
import model.ParkingSpot;
import repository.IRepository;

import java.util.UUID;

public class Controller {

    private final IRepository repo;

    public Controller(IRepository repo){
        this.repo = repo;
    }

    public void getParkingSpots(Context ctx){
        ctx.json(repo.getParkingSpots());
    }

    public void getParkingSpot(Context ctx){
        String parkingSpotId = ctx.pathParam(":parking-spot-id");
        ParkingSpot parkingSpot = repo.getParkingSpot(UUID.fromString(parkingSpotId));
        ctx.json(parkingSpot);
    }

    public void getPosts(Context ctx){
        ctx.json(repo.getPosts());
    }

    public void getPost(Context ctx) {
        String postId = ctx.pathParam(":post-id");
        ctx.json(repo.getPost(UUID.fromString(postId)));
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
        Account account = repo.getAccount(accountId);
        ctx.json(repo.getOwnedParkingSpots(account));
    }

    public void getRentedParkingSpots(Context ctx) {
        UUID accountId = UUID.fromString(ctx.pathParam(":account-id"));
        Account account = repo.getAccount(accountId);
        ctx.json(repo.getRentedParkingSpots(account));
    }

    public void createParking(Context ctx) {
        repo.createParkingSpot(ctx.formParamMap());
        System.out.println(ctx.formParamMap());
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
}
