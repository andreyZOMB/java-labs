import java.util.Arrays;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        // Создание массива объектов класса Ward
        Ward[] wards = new Ward[10];

        // Заполнение массива объектами
        wards[0] = new Ward(5, "Dr. Smith", true);
        wards[1] = new Ward(3, "Dr. Johnson", false);
        wards[2] = null;
        wards[3] = new Ward(); // Объект, созданный конструктором по умолчанию
        wards[4] = new Ward(2, "Dr. Brown", true);
        wards[5] = new Ward(4, "Dr. Davis", true);
        wards[6] = new Ward(1, "Dr. Wilson", false);
        wards[7] = new Ward(6, "Dr. Miller", true);
        wards[8] = new Ward(3, "Dr. Anderson", false);
        wards[9] = new Ward(4, "Dr. Taylor", true);

        // Упорядочивание массива по возрастанию целочисленных параметров и строковых
        Arrays.sort(wards, Comparator.comparingInt(Ward::getNumberOfBeds).thenComparing(Ward::getDoctorName));

        // Вывод массива три раза
        for (int i = 0; i < 3; i++) {
            System.out.println("Iteration: " + (i + 1));
            for (Ward ward : wards) {
                if (ward != null) {
                    System.out.println("Number of beds: " + ward.getNumberOfBeds());
                    System.out.println("Doctor name: " + ward.getDoctorName());
                    System.out.println("Has available beds: " + ward.hasAvailableBeds());
                    System.out.println();
                } else {
                    System.out.println("Null ward");
                    System.out.println();
                }
            }
        }
        // Подсчет общего количества мест и палат с свободными койками
        int totalNumberOfBeds = 0;
        int numberOfWardsWithAvailableBeds = 0;

        for (Ward ward : wards) {
            if (ward != null) {
                totalNumberOfBeds += ward.getNumberOfBeds();
                if (ward.hasAvailableBeds()) {
                    numberOfWardsWithAvailableBeds++;
                }
            }
        }

        System.out.println("Total number of beds: " + totalNumberOfBeds);
        System.out.println("Number of wards with available beds: " + numberOfWardsWithAvailableBeds);
    }
}