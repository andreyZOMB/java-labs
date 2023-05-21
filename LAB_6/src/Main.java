import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>();

        try {
            houses = readHousesFromFile("input.txt");
            System.out.println("Исходный список квартир:");
            printHouseList(houses);

            // Сортировка по полю "Улица" в возрастающем порядке
            Collections.sort(houses);

            System.out.println("Список квартир после сортировки:");
            printHouseList(houses);


            // Фильтрация квартир с заданным числом комнат
            int targetRoomCount = 2;
            List<House> filteredByRoomCount = filterByRoomCount(houses, targetRoomCount);
            System.out.println("Список квартир с " + targetRoomCount + " комнат(ой):");
            printHouseList(filteredByRoomCount);

            // Фильтрация квартир с заданным числом комнат и этажом в заданном промежутке

            int targetFloorStart = 2;
            int targetFloorEnd = 5;
            List<House> filteredByRoomCountAndFloor = filterByRoomCountAndFloor(houses, targetRoomCount, targetFloorStart, targetFloorEnd);
            System.out.println("Список квартир с " + targetRoomCount + " комнат(ой) на этажах с " + targetFloorStart + " по " + targetFloorEnd + ":");
            printHouseList(filteredByRoomCountAndFloor);

            // Фильтрация квартир с площадью, превосходящей заданное значение
            double targetArea = 80.0;
            List<House> filteredByArea = filterByArea(houses, targetArea);
            System.out.println("Список квартир с площадью, превосходящей " + targetArea + ":");
            printHouseList(filteredByArea);

            // Запись результата в другой файл
            writeHousesToFile(filteredByArea, "output.txt");
            System.out.println("Результат успешно записан в файл 'output.txt'.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объектов из файла: " + e.getMessage());
        }
    }

    public static List<House> readHousesFromFile(String filename) throws IOException, ClassNotFoundException {
        List<House> houses = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            houses = (List<House>) objectIn.readObject();
        }

        return houses;
    }

    public static void writeHousesToFile(List<House> houses, String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(houses);
        }
    }

    public static void printHouseList(List<House> houses) {
        for (House house : houses) {
            System.out.println(house);
        }
    }

    public static List<House> filterByRoomCount(List<House> houses, int roomCount) {
        List<House> filteredHouses = new ArrayList<>();

        for (House house : houses) {
            if (house.getRoomCount() == roomCount) {
                filteredHouses.add(house);
            }
        }

        return filteredHouses;
    }

    public static List<House> filterByRoomCountAndFloor(List<House> houses, int roomCount, int floorStart, int floorEnd) {
        List<House> filteredHouses = new ArrayList<>();

        for (House house : houses) {
            if (house.getRoomCount() == roomCount && house.getFloor() >= floorStart && house.getFloor() <= floorEnd) {
                filteredHouses.add(house);
            }
        }

        return filteredHouses;
    }

    public static List<House> filterByArea(List<House> houses, double area) {
        List<House> filteredHouses = new ArrayList<>();

        for (House house : houses) {
            if (house.getArea() > area) {
                filteredHouses.add(house);
            }
        }

        return filteredHouses;
    }
}