import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class does_JSON_files_exist {

    String folderPath = "src/main/resources/json/";

    @Test
    public void does_accounts_file_exist() {
        Path path = Paths.get(folderPath + "accounts.json");
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    public void does_parkingSpots_file_exist() {
        Path path = Paths.get(folderPath + "parkingSpots.json");
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    public void does_posts_file_exist() {
        Path path = Paths.get(folderPath + "posts.json");
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    public void does_reservations_file_exist() {
        Path path = Paths.get(folderPath + "reservations.json");
        Assertions.assertTrue(Files.exists(path));
    }

}
