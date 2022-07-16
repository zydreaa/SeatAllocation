public class Seat {

    public int seatId;
    public String seatType;
    public String seatPosition;
    public int amount;

    public Seat(int seatId, String seatType, String seatPosition, int amount) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatPosition = seatPosition;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Seat ID: " + seatId +
                " | Seat type: " + seatType +
                " | Seat position: " + seatPosition +
                " | Amount: " + amount + "\n";
    }

}