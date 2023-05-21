// Пакет transport
package transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Абстрактный класс Transport
public abstract class Transport {
    // Конструкторы
    public Transport() {
        // Конструктор по умолчанию
    }

    // Методы и свойства
    public abstract void calculatePassengerAndBaggage(); // Метод для подсчета численности пассажиров и багажа
    public abstract void sortCarriagesByComfortLevel(); // Метод для сортировки вагонов по уровню комфортности
    public abstract void findCarriagesByPassengerRange(int minPassengers, int maxPassengers); // Метод для поиска вагонов по заданному диапазону числа пассажиров
}

