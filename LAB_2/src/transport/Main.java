package transport;

import java.util.ArrayList;
import java.util.List;

// Класс Main (для запуска приложения)
public class Main {
    public static void main(String[] args) {
        WriterInfo writer = new WriterInfo();
        writer.displayInfo();

        // Создание пассажирского поезда с вагонами
        List<PassengerCarriage> passengerCarriages = new ArrayList<>();
        passengerCarriages.add(new PassengerCarriage(1, 50, ComfortLevel.MEDIUM));
        passengerCarriages.add(new PassengerCarriage(2, 40, ComfortLevel.HIGH));
        passengerCarriages.add(new PassengerCarriage(3, 30, ComfortLevel.LOW));

        List<BaggageCarriage> baggageCarriages = new ArrayList<>();
        baggageCarriages.add(new BaggageCarriage(1, 100));
        baggageCarriages.add(new BaggageCarriage(2, 80));
        baggageCarriages.add(new BaggageCarriage(3, 60));
        Train train = new Train(passengerCarriages, baggageCarriages);

        // Вызов методов для подсчета численности пассажиров и багажа, сортировки вагонов и поиска вагонов по диапазону пассажиров
        train.calculatePassengerAndBaggage();
        train.sortCarriagesByComfortLevel();
        train.findCarriagesByPassengerRange(30, 50);
    }
}
