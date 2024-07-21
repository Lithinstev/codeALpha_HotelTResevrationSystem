import java.util.Date;

class Reservation {
    private int reservationId;
    private Room room;
    private String guestName;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalCost;

    public Reservation(int reservationId, Room room, String guestName, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalCost() {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        return days * room.getPrice();
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", room=" + room +
                ", guestName='" + guestName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalCost=" + totalCost +
                '}';
    }
}
