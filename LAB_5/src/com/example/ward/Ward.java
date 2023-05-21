package com.example.ward;

import java.util.List;

public class Ward {
    private int capacity;
    private String doctorName;
    private int availableBeds;

    public Ward(int capacity, String doctorName, int availableBeds) {
        this.capacity = capacity;
        this.doctorName = doctorName;
        this.availableBeds = availableBeds;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        if (availableBeds < 0) {
            throw new IllegalArgumentException("Available beds cannot be negative");
        }
        this.availableBeds = availableBeds;
    }

    public void countTotalCapacity(List<Ward> wards) {
        int totalCapacity = 0;
        for (Ward ward : wards) {
            totalCapacity += ward.getCapacity();
        }
        System.out.println("Total Capacity: " + totalCapacity);
    }

    public void countWardsWithAvailableBeds(List<Ward> wards) {
        int wardsWithAvailableBeds = 0;
        for (Ward ward : wards) {
            if (ward.getAvailableBeds() > 0) {
                wardsWithAvailableBeds++;
            }
        }
        System.out.println("Wards with Available Beds: " + wardsWithAvailableBeds);
    }
}
