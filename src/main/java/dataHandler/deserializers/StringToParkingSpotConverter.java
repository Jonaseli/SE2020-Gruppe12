package dataHandler.deserializers;

import com.fasterxml.jackson.databind.util.StdConverter;
import model.ParkingSpot;
import repository.Repository;

import java.util.stream.Collectors;

public class StringToParkingSpotConverter extends StdConverter<String, ParkingSpot> {
    @Override
    public ParkingSpot convert(String parkingSpotId) {
        return Repository.parkingSpots.stream()
                .filter((parkingSpot) -> parkingSpot.getParkingSpotId().toString().equals(parkingSpotId))
                .collect(Collectors.toList()).get(0);
    }
}
