package transport;

// Класс PassengerCarriage
public class PassengerCarriage extends Train {
    // Поля
    private int id;
    private int numberOfPassengers;
    private ComfortLevel comfortLevel;

    // Конструкторы
    public PassengerCarriage(int id, int numberOfPassengers, ComfortLevel comfortLevel) {
        this.id = id;
        this.numberOfPassengers = numberOfPassengers;
        this.comfortLevel = comfortLevel;
    }

    // Методы доступа

    public int getId() {
        return id;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public int getBaggageCapacity() {
        return 0;
    }
}
