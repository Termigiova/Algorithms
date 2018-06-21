package Chapter1.Section2.exercise11;

public class InvalidDateException extends Exception {
    private int date;

    public InvalidDateException(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
