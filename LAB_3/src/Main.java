import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Ward> wards = new ArrayList<>();

        // Ввод параметров палат с помощью командной строки
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Введите количество мест для палаты " + (i + 1) + ":");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после ввода числа

            System.out.println("Введите фамилию врача для палаты " + (i + 1) + ":");
            String doctorSurname = scanner.nextLine();

            System.out.println("Введите количество свободных коек для палаты " + (i + 1) + ":");
            int availableBeds = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после ввода числа

            wards.add(new Ward(capacity, doctorSurname, availableBeds));
        }

        // Сохранение списка палат в файл
        WardSerializer serializer = new WardSerializer();
        try {
            serializer.serialize(wards, "wards.ser");
            System.out.println("Объекты успешно сериализованы и сохранены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации и сохранении объектов в файл.");
            e.printStackTrace();
        }

        // Чтение списка палат из файла
        try {
            List<Ward> deserializedWards = serializer.deserialize("wards.ser");
            System.out.println("Объекты успешно десериализованы из файла.");

            // Вывод информации о палатах
            for (Ward ward : deserializedWards) {
                System.out.println("Количество мест: " + ward.getCapacity());
                System.out.println("Фамилия врача: " + ward.getDoctorSurname());
                System.out.println("Наличие свободных коек: " + ward.getAvailableBeds());
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации объектов из файла.");
            e.printStackTrace();
        }
    }
}

class Ward implements Serializable {
    private int capacity;
    private String doctorSurname;
    private int availableBeds;

    public Ward(int capacity, String doctorSurname, int availableBeds) {
        this.capacity = capacity;
        this.doctorSurname = doctorSurname;
        this.availableBeds = availableBeds;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }
}

class WardSerializer {
    public void serialize(List<Ward> wards, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(wards);
        }
    }
    public List<Ward> deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Ward>) ois.readObject();
        }
    }
}