import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        // Add some rooms
        hotel.addRoom(new Room(101, RoomType.SINGLE, 100));
        hotel.addRoom(new Room(102, RoomType.DOUBLE, 150));
        hotel.addRoom(new Room(103, RoomType.SUITE, 200));

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Process Payment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (1-SINGLE, 2-DOUBLE, 3-SUITE): ");
                    int roomType = scanner.nextInt();
                    System.out.print("Enter check-in date (yyyy-mm-dd): ");
                    String checkIn = scanner.next();
                    System.out.print("Enter check-out date (yyyy-mm-dd): ");
                    String checkOut = scanner.next();

                    RoomType type = roomType == 1 ? RoomType.SINGLE : roomType == 2 ? RoomType.DOUBLE : RoomType.SUITE;
                    List<Room> availableRooms = hotel.searchAvailableRooms(type, parseDate(checkIn), parseDate(checkOut));

                    System.out.println("Available Rooms:");
                    for (Room room : availableRooms) {
                        System.out.println(room);
                    }
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.next();
                    System.out.print("Enter check-in date (yyyy-mm-dd): ");
                    checkIn = scanner.next();
                    System.out.print("Enter check-out date (yyyy-mm-dd): ");
                    checkOut = scanner.next();

                    Room room = findRoomByNumber(hotel, roomNumber);
                    if (room != null && room.isAvailable()) {
                        Reservation reservation = hotel.makeReservation(room, guestName, parseDate(checkIn), parseDate(checkOut));
                        System.out.println("Reservation successful: " + reservation);
                    } else {
                        System.out.println("Room not available or invalid room number.");
                    }
                    break;

                case 3:
                    System.out.print("Enter reservation ID: ");
                    int reservationId = scanner.nextInt();
                    Reservation reservation = hotel.getReservationDetails(reservationId);
                    if (reservation != null) {
                        System.out.println("Booking Details: " + reservation);
                    } else {
                        System.out.println("Invalid reservation ID.");
                    }
                    break;

                case 4:
                    System.out.print("Enter reservation ID: ");
                    reservationId = scanner.nextInt();
                    System.out.print("Enter payment amount: ");
                    double amount = scanner.nextDouble();
                    Payment payment = hotel.processPayment(reservationId, amount);
                    System.out.println("Payment processed: " + payment);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Room findRoomByNumber(Hotel hotel, int roomNumber) {
        for (Room room : hotel.getRooms()) {  // Corrected to iterate over rooms
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
