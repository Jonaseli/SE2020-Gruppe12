package model;

public class ParkingSpot implements JSONReadable<ParkingSpot>, JSONWritable<ParkingSpot> {
    private String owner;
    private String type;
    private boolean available;
    private int width, height;
    private String postalCode, streetAddress, streetNumber;
    private String pictureURL;

    public ParkingSpot(){}

    public ParkingSpot(String owner, String type, boolean available, int width,
                       int height, String postalCode, String streetAddress,
                       String streetNumber, String pictureURL){
        this.owner = owner;
        this.type = type;
        this.available = available;
        this.width = width;
        this.height = height;
        this.postalCode = postalCode;
        this.streetAddress = streetAddress;
        this.streetNumber = streetNumber;
        this.pictureURL = pictureURL;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
