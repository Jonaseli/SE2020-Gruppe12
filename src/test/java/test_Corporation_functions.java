import model.Corporation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_Corporation_functions {

    @Test
    public void get_Corporation_Id(){
        Corporation testCorporation_ID = new Corporation();

        assertEquals("ID"
                ,testCorporation_ID.getAccountId());
        assertEquals("3221"
                ,testCorporation_ID.getAccountId());
    }

    @Test
    public void get_Corporation_Name(){
        Corporation testCorporation_Name = new Corporation();

        assertEquals("Olav",
                testCorporation_Name.getDisplayName());
        assertEquals("Lise",
                testCorporation_Name.getDisplayName());
    }


    @Test
    public void get_Corporation_Suspended_Status(){
        Corporation testCorporation_Suspended = new Corporation();

        assertEquals(true,
                testCorporation_Suspended.isSuspended());
        assertEquals(false,
                testCorporation_Suspended.isSuspended());
    }
}
