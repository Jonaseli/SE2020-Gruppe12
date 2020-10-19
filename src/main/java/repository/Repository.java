package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ParkingSpot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository implements IRepository{
    private File file;
    //TODO create these classes
    //private ArrayList<Account> accounts;
    private ArrayList<ParkingSpot> parkingSpots;
    //private ArrayList<Post> posts;

    public Repository(File file){
        this.file = file;
        parkingSpots = readValues();

        //Some code to test if object were created, remove later.
        System.out.println(parkingSpots);
        System.out.println(parkingSpots.get(0).getOwner());
    }

    private ArrayList<ParkingSpot> readValues(){
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            ParkingSpot[] parkingSpotsArray = (objectMapper.readValue(file, ParkingSpot[].class));
            parkingSpots = Arrays.asList(parkingSpotsArray);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
        return new ArrayList<>(parkingSpots);
    }

    //TODO method for writing to file.

    @Override
    public ParkingSpot getParkingSpot(String spotID) { return null; }

    @Override
    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
