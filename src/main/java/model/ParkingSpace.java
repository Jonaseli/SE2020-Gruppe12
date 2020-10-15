package model;

public class ParkingSpace {
    private String status;
    private int width, height;
    private int quantity;
    private boolean handicapped;
    private String city, street;
    private int postalCode, streetNumber;

    public ParkingSpace(String status, int width, int height, int quantity, boolean handicapped,
                        String city, String street, int postalCode, int streetNumber) {
        this.status = status;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.handicapped = handicapped;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.streetNumber = streetNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isHandicapped() {
        return handicapped;
    }

    public void setHandicapped(boolean handicapped) {
        this.handicapped = handicapped;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
