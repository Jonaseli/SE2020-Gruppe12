import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.Repository;

public class reading_from_file {

    static Repository repo;

    @BeforeAll
    public static void setup(){
        String[] filesPaths = new String[4];

        filesPaths[0] = "parkingSpots.json";
        filesPaths[1] = "accounts.json";
        filesPaths[2] = "posts.json";
        filesPaths[3] = "reservations.json";

        repo = new Repository(filesPaths);
    }

    @Test
    public void parkingSpot_object_created(){
        Assertions.assertNotNull(repo.getParkingSpots());
    }

    @Test
    public void account_object_created(){
        Assertions.assertNotNull(repo.getAccounts());
    }

    @Test
    public void post_object_created(){
        Assertions.assertNotNull(repo.getPosts());
    }

    @Test
    public void reservation_object_created(){
        Assertions.assertNotNull(repo.getReservations());
    }

}
