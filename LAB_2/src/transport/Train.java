package transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Класс Train
public class Train extends Transport {
    // Поля
    private List<PassengerCarriage> passengerCarriages;
    private List<BaggageCarriage> baggageCarriages;

    // Конструкторы
    public Train() {
        // Конструктор по умолчанию
        passengerCarriages = new ArrayList<>();
        baggageCarriages = new ArrayList<>();
    }

    public Train(List<PassengerCarriage> passengerCarriages, List<BaggageCarriage> baggageCarriages) {
        this.passengerCarriages = passengerCarriages;
        this.baggageCarriages = baggageCarriages;
    }

    // Переопределение методов базового класса
    @Override
    public void calculatePassengerAndBaggage() {
        int totalPassengers = 0;
        int totalBaggage = 0;

        for (PassengerCarriage carriage : passengerCarriages) {
            totalPassengers += carriage.getNumberOfPassengers();
            totalBaggage += carriage.getBaggageCapacity();
        }

        System.out.println("Total passengers: " + totalPassengers);
        System.out.println("Total baggage: " + totalBaggage);
    }

    @Override
    public void sortCarriagesByComfortLevel() {
        Collections.sort(passengerCarriages, new Comparator<PassengerCarriage>() {
            @Override
            public int compare(PassengerCarriage c1, PassengerCarriage c2) {
                return c1.getComfortLevel().compareTo(c2.getComfortLevel());
            }
        });

        System.out.println("Sorted carriages by comfort level:");
        for (PassengerCarriage carriage : passengerCarriages) {
            System.out.println("Comfort Level: " + carriage.getComfortLevel());
        }
    }

    @Override
    public void findCarriagesByPassengerRange(int minPassengers, int maxPassengers) {
        System.out.println("Carriages with passenger capacity between " + minPassengers + " and " + maxPassengers + ":");

        for (PassengerCarriage carriage : passengerCarriages) {
            int passengers = carriage.getNumberOfPassengers();
            if (passengers >= minPassengers && passengers <= maxPassengers) {
                System.out.println("Carriage ID: " + carriage.getId());
                System.out.println("Number of Passengers: " + passengers);
            }
        }
    }
}
