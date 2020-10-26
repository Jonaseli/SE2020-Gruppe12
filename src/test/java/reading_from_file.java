import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.Repository;

public class reading_from_file {

    static Repository repo;

    @BeforeAll
    public static void setup(){
        repo = new Repository();
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
