package transport;

// Класс BaggageCarriage
public class BaggageCarriage extends Train {
    // Поля
    private int id;
    private int baggageCapacity;

    // Конструкторы
    public BaggageCarriage(int id, int baggageCapacity) {
        this.id = id;
        this.baggageCapacity = baggageCapacity;
    }

    // Методы доступа

    public int getId() {
        return id;
    }

    public int getBaggageCapacity() {
        return baggageCapacity;
    }
}
