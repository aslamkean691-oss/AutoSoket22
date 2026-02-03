package com.example.cars.model;

public class car {
    private String type;              // סוג רכב
    private String registrationDate;  // תאריך עליה לכביש
    private String color;             // צבע
    private int kms;              // קילומתראז
    private int hands;          // ידיים
    private String ownership;         // סוג בעלות
    private double priceList;         // מחירון
    private double price;// מחיר

    public String getType() {
        return type;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getColor() {
        return color;
    }

    public int getKms() {
        return kms;
    }

    public int getHands() {
        return hands;
    }

    public String getOwnership() {
        return ownership;
    }

    public double getPriceList() {
        return priceList;
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public void setPriceList(double priceList) {
        this.priceList = priceList;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public car() {
    }

    public car(String type, String registrationDate, String color, int kms, int hands, String ownership, double priceList, double price) {
        this.type = type;
        this.registrationDate = registrationDate;
        this.color = color;
        this.kms = kms;
        this.hands = hands;
        this.ownership = ownership;
        this.priceList = priceList;
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "type='" + type + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", color='" + color + '\'' +
                ", kms=" + kms +
                ", hands=" + hands +
                ", ownership='" + ownership + '\'' +
                ", priceList=" + priceList +
                ", price=" + price +
                '}';
    }
}
