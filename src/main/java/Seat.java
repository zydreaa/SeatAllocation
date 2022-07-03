public class Seat {

    public int seatId;
    public String seatType;
    public String seatPosition;
    public int amount;

    public Seat() {}

    public Seat(int seatId, String seatType, String seatPosition, int amount) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatPosition = seatPosition;
        this.amount = amount;
    }

    public Seat(int seatId, int amount) {
        this.seatId = seatId;
        this.amount = amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(String seatPosition) {
        this.seatPosition = seatPosition;
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