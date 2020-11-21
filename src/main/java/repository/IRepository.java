package repository;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IRepository {

    Account getAccount(UUID accountId);

    ArrayList<Account> getAccounts();

    void createAccount(String displayName);

    Post getPost(UUID postId);

    ArrayList<Post> getPosts();

    void createPost(UUID parkingSpotId, double price);

    ParkingSpot getParkingSpot(UUID parkingSpotId);

    ArrayList<ParkingSpot> getParkingSpots();

    ArrayList<ParkingSpot> getOwnedParkingSpots(UUID accountId);

    ArrayList<ParkingSpot> getRentedParkingSpots(UUID accountId);

    void createParkingSpot(Map<String, List<String>> values);

    Reservation getReservation(UUID reservationId);

    ArrayList<Reservation> getReservations();

    void createReservation(UUID postId, UUID userId, String startTime, String endTime);

    void deleteAccount(UUID accountId);

    void deleteReservation(UUID reservationId);

    void deletePost(UUID postId);

    void deleteParkingSpot(UUID parkingSpotId);

    void suspendAccount(UUID accountId);
}
