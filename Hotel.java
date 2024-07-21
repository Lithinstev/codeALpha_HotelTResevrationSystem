import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;
    private List<Payment> payments;
    private int nextReservationId;
    private int nextPaymentId;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        payments = new ArrayList<>();
        nextReservationId = 1;
        nextPaymentId = 1;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> searchAvailableRooms(RoomType type, Date checkInDate, Date checkOutDate) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getType() == type && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Reservation makeReservation(Room room, String guestName, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(nextReservationId++, room, guestName, checkInDate, checkOutDate);
        room.setAvailable(false);
        reservations.add(reservation);
        return reservation;
    }

    public Payment processPayment(int reservationId, double amount) {
        Payment payment = new Payment(nextPaymentId++, reservationId, amount);
        payment.setPaid(true);
        payments.add(payment);
        return payment;
    }

    public Reservation getReservationDetails(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    public List<Room> getRooms() {  // Added getter for rooms
        return rooms;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
