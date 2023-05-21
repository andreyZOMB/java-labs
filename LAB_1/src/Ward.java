public class Ward {
    private int numberOfBeds;
    private String doctorName;
    private boolean hasAvailableBeds;

    // Конструктор по умолчанию
    public Ward() {
        this.numberOfBeds = 0;
        this.doctorName = "";
        this.hasAvailableBeds = false;
    }

    // Перегруженный конструктор
    public Ward(int numberOfBeds, String doctorName, boolean hasAvailableBeds) {
        this.numberOfBeds = numberOfBeds;
        this.doctorName = doctorName;
        this.hasAvailableBeds = hasAvailableBeds;
    }

    // Геттеры и сеттеры

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean hasAvailableBeds() {
        return hasAvailableBeds;
    }

    public void setHasAvailableBeds(boolean hasAvailableBeds) {
        this.hasAvailableBeds = hasAvailableBeds;
    }
}
