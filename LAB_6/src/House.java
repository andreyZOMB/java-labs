import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class House implements Comparable<House>, Serializable {
    private int id;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int roomCount;
    private String street;
    private String buildingType;
    private int yearsInUse;

    public House(int id, int apartmentNumber, double area, int floor, int roomCount, String street,
                 String buildingType, int yearsInUse) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.roomCount = roomCount;
        this.street = street;
        this.buildingType = buildingType;
        this.yearsInUse = yearsInUse;
    }

    public int getId() {
        return id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getYearsInUse() {
        return yearsInUse;
    }

    @Override
    public int compareTo(House other) {
        return this.street.compareTo(other.street);
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", apartmentNumber=" + apartmentNumber +
                ", area=" + area +
                ", floor=" + floor +
                ", roomCount=" + roomCount +
                ", street=" + street + '\'' +
                ", buildingType=" + buildingType + '\'' +
                ", yearsInUse=" + yearsInUse +
                '}';
    }
}
