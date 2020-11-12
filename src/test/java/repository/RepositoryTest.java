package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.util.UUID;

public class RepositoryTest {

    @Test
    public void are_account_JSON_values_retrieved_correctly() {
        Repository testRepo = new Repository();

        // Order of strings in arrays matter! Might switch to KeyVal
        String[] accountId = {"6648dfdc-9733-4a34-bfa0-e9de8c1ca78b", "265e6a29-5c0a-41ab-9cb7-7d7292ff0b0f"};
        String[] expected = {"Ole Hansen", "Tom Jørnstad"};

        String actual0 = testRepo.getAccount(UUID.fromString(accountId[0])).getDisplayName();
        Assertions.assertEquals(actual0, expected[0]);

        String actual1 = testRepo.getAccount(UUID.fromString(accountId[1])).getDisplayName();
        Assertions.assertEquals(actual1, expected[1]);
    }

    @Test
    public void are_JSON_values_updated_correctly() {
        Repository testRepo = new Repository();



    }

}
