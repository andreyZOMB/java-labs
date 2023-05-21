import com.example.ward.Ward;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ward> wards = new ArrayList<>();

        // Чтение параметров из файла
        try (BufferedReader reader = new BufferedReader(new FileReader("wards.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] params = line.split(",");
                if (params.length == 3) {
                    int capacity = Integer.parseInt(params[0].trim());
                    String doctorName = params[1].trim();
                    int availableBeds = Integer.parseInt(params[2].trim());
                    Ward ward = new Ward(capacity, doctorName, availableBeds);
                    wards.add(ward);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid format in file: " + e.getMessage());
            return;
        }

        // Обработка исключений при выполнении операций
        try {
            wards.get(0).setAvailableBeds(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument: " + e.getMessage());
            return;
        }

        // Выполнение задач и вывод результатов
        Ward ward = new Ward(20, "Dr. Smith", 10);
        ward.countTotalCapacity(wards);
        ward.countWardsWithAvailableBeds(wards);
    }
}

