package dataHandler.serializers;

import com.fasterxml.jackson.databind.util.StdConverter;
import model.ParkingSpot;

public class ParkingSpotToStringConverter extends StdConverter<ParkingSpot, String> {
    @Override
    public String convert(ParkingSpot parkingSpot) {
        return parkingSpot.getParkingSpotId().toString();
    }
}
