package problems;

class Seat {
    boolean booked;
    public boolean book() {
        booked = true;
        return true;
    }

    public boolean available() {
        return !booked;
    }

    public String status() {
        return booked ? "1" : "0";
    }
}
