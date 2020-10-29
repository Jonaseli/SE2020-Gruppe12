import model.Corporation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_Corporation_functions {

    @Test
    public void get_Corporation_Id(){
        Corporation testCorporation_ID = new Corporation();

        assertEquals("ID"
                ,testCorporation_ID.getAccountId("ID"));
        assertEquals("3221"
                ,testCorporation_ID.getAccountId("3221"));
    }

    @Test
    public void get_Corporation_Name(){
        Corporation testgCorporation_Name = new Corporation();

        assertEquals("Olav",
                testgCorporation_Name.getDisplayName("Olav"));
        assertEquals("Lise",
                testgCorporation_Name.getDisplayName("Lise"));
    }


    @Test
    public void get_Corporation_Suspended_Status(){
        Corporation testCorporation_Suspended = new Corporation();

        assertEquals(true,
                testCorporation_Suspended.isSuspended(true));
        assertEquals(false,
                testCorporation_Suspended.isSuspended(false));
    }
}
