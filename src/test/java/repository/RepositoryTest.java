package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RepositoryTest {
    Repository repo = new Repository();

    @Test
    public void are_account_JSON_values_retrieved_correctly() {
        // Order of strings in arrays matter! Might switch to KeyVal
        String[] accountId = {"6648dfdc-9733-4a34-bfa0-e9de8c1ca78b", "265e6a29-5c0a-41ab-9cb7-7d7292ff0b0f"};
        String[] expectedDisplayName = {"Ole Hansen", "Tom Jørnstad"};

        for (int i = 0; i < accountId.length; i++) {
            String actualDisplayName = repo.getAccount(UUID.fromString(accountId[i])).getDisplayName();
            Assertions.assertEquals(actualDisplayName, expectedDisplayName[i]);
        }
    }

    @Test
    public void are_parking_spot_JSON_values_retrieved_correctly() {
        // Order of strings in arrays matter! Might switch to KeyVal
        String[] parkingSpotId = {"079433fa-d2fc-42b6-9514-7cdaabf35909", "a88c0610-6dc7-4ea3-b871-f3d1672c1730", "95d610af-3a5f-4e67-8c72-384aeb562a5b"};
        String[] expectedOwnerId = {"6648dfdc-9733-4a34-bfa0-e9de8c1ca78b", "265e6a29-5c0a-41ab-9cb7-7d7292ff0b0f", "d7d77c76-5b91-4fb4-8eab-80389a90d427"};

        for (int i = 0; i < parkingSpotId.length; i++) {
            String actualOwnerId = repo.getParkingSpot(UUID.fromString(parkingSpotId[i])).getOwner().toString();
            Assertions.assertEquals(actualOwnerId, expectedOwnerId[i]);
        }
    }

    @Test
    public void are_JSON_values_updated_correctly() {
        Repository testRepo = new Repository();

        String[] ownerId = {"6648dfdc-9733-4a34-bfa0-e9de8c1ca78b", "265e6a29-5c0a-41ab-9cb7-7d7292ff0b0f"};
        /*
        UUID testUser = testRepo.getAccount(UUID.fromString(ownerId[0]));
        UUID user = repo.getAccount(UUID.fromString(ownerId[0]));

        testUser.setSuspended(true);
        Assertions.assertNotEquals(user.isSuspended(), testUser.isSuspended());
        */
    }
}
