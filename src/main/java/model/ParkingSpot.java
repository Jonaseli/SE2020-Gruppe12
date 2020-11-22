package model;

import java.util.UUID;

public class ParkingSpot {

    private UUID parkingSpotId;
    private UUID owner;
    private boolean available, handicap, chargingStation;
    private int width, length, height;
    private String postalCode, city, streetAddress, streetNumber;
    private String pictureURL;

    public ParkingSpot() {
    }

    public ParkingSpot(UUID owner, boolean handicap, boolean chargingStation, boolean available, int width,
                       int length, int height, String postalCode, String city, String streetAddress,
                       String streetNumber, String pictureURL) {
        this.parkingSpotId = UUID.randomUUID();
        this.owner = owner;
        this.handicap = handicap;
        this.chargingStation = chargingStation;
        this.available = available;
        this.width = width;
        this.length = length;
        this.height = height;
        this.postalCode = postalCode;
        this.city = city;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.pictureURL = pictureURL;
    }

    public ParkingSpot(UUID parkingSpotId, UUID owner, boolean handicap, boolean chargingStation, boolean available, int width,
                       int length, int height, String postalCode, String city, String streetAddress,
                       String streetNumber, String pictureURL) {
        this.parkingSpotId = parkingSpotId;
        this.owner = owner;
        this.handicap = handicap;
        this.chargingStation = chargingStation;
        this.available = available;
        this.width = width;
        this.length = length;
        this.height = height;
        this.postalCode = postalCode;
        this.city = city;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.pictureURL = pictureURL;
    }

    public UUID getParkingSpotId() {
        return parkingSpotId;
    }

    public UUID getOwner() {
        return owner;
    }

    public boolean getHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public boolean getChargingStation() {
        return chargingStation;
    }

    public void setChargingStation(boolean chargingStation) {
        this.chargingStation = chargingStation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}
