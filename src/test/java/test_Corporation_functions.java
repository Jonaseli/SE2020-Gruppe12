import model.Corporation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_Corporation_functions {

    @Test
    public void get_Corporation_ID(){
        Corporation testCorporation_ID = new Corporation();

        assertEquals("ID"
                ,testCorporation_ID.getCorporation_ID("ID"));
        assertEquals("3221"
                ,testCorporation_ID.getCorporation_ID("3221"));
    }

    @Test
    public void get_Corporation_Name(){
        Corporation testgCorporation_Name = new Corporation();

        assertEquals("Olav",
                testgCorporation_Name.getCorporation_Name("Olav"));
        assertEquals("Lise",
                testgCorporation_Name.getCorporation_Name("Lise"));
    }


    @Test
    public void get_Corporation_Suspended_Status(){
        Corporation testCorporation_Suspended = new Corporation();

        assertEquals(true,
                testCorporation_Suspended.getCorporation_Suspended_Status(true));
        assertEquals(false,
                testCorporation_Suspended.getCorporation_Suspended_Status(false));
    }
}
