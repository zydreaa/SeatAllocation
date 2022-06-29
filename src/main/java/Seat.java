import java.util.ArrayList;

public class Seat {

    public int businessSeats = 2;
    public int economicSeats = 10;
    public String seatType;
    public boolean isBooked;
    public String seatPosition;

    public Seat(String seatType, String seatPosition) {
        this.seatType = seatType;
        this.seatPosition = seatPosition;
    }

    public boolean isBooked() {
        return isBooked; // it is True, otherwise is false
    }
}
