# Hotel Reservation System

## Description

This project is a simplified hotel reservation system written in Java. It includes features such as searching for available rooms, making reservations, viewing booking details, room categorization, and payment processing.

## Classes and Methods

### Room Class
- **Attributes:**
  - `roomNumber`: The room number.
  - `type`: The type of the room (`RoomType` enum).
  - `price`: The price of the room per night.
  - `isAvailable`: Indicates if the room is available.

- **Methods:**
  - `Room(int roomNumber, RoomType type, double price)`: Constructor to initialize the room.
  - `getRoomNumber()`: Returns the room number.
  - `getType()`: Returns the type of the room.
  - `getPrice()`: Returns the price of the room.
  - `isAvailable()`: Returns if the room is available.
  - `setAvailable(boolean isAvailable)`: Sets the availability status of the room.
  - `toString()`: Returns a string representation of the room.

### Reservation Class
- **Attributes:**
  - `reservationId`: The ID of the reservation.
  - `room`: The room being reserved.
  - `guestName`: The name of the guest.
  - `checkInDate`: The check-in date.
  - `checkOutDate`: The check-out date.
  - `totalCost`: The total cost of the reservation.

- **Methods:**
  - `Reservation(int reservationId, Room room, String guestName, Date checkInDate, Date checkOutDate)`: Constructor to initialize the reservation.
  - `getReservationId()`: Returns the reservation ID.
  - `getRoom()`: Returns the room.
  - `getGuestName()`: Returns the guest name.
  - `getCheckInDate()`: Returns the check-in date.
  - `getCheckOutDate()`: Returns the check-out date.
  - `getTotalCost()`: Returns the total cost.
  - `toString()`: Returns a string representation of the reservation.

### Payment Class
- **Attributes:**
  - `paymentId`: The ID of the payment.
  - `reservationId`: The ID of the reservation associated with the payment.
  - `amount`: The amount of the payment.
  - `isPaid`: Indicates if the payment has been made.

- **Methods:**
  - `Payment(int paymentId, int reservationId, double amount)`: Constructor to initialize the payment.
  - `getPaymentId()`: Returns the payment ID.
  - `getReservationId()`: Returns the reservation ID.
  - `getAmount()`: Returns the payment amount.
  - `isPaid()`: Returns if the payment has been made.
  - `setPaid(boolean isPaid)`: Sets the payment status.
  - `toString()`: Returns a string representation of the payment.

### Hotel Class
- **Attributes:**
  - `rooms`: A list of rooms in the hotel.
  - `reservations`: A list of reservations.
  - `payments`: A list of payments.
  - `nextReservationId`: The next reservation ID.
  - `nextPaymentId`: The next payment ID.

- **Methods:**
  - `Hotel()`: Constructor to initialize the hotel.
  - `addRoom(Room room)`: Adds a room to the hotel.
  - `searchAvailableRooms(RoomType type, Date checkInDate, Date checkOutDate)`: Searches for available rooms.
  - `makeReservation(Room room, String guestName, Date checkInDate, Date checkOutDate)`: Makes a reservation.
  - `processPayment(int reservationId, double amount)`: Processes a payment.
  - `getReservationDetails(int reservationId)`: Gets reservation details by ID.
  - `getRooms()`: Returns the list of rooms.
  - `getAllReservations()`: Returns the list of all reservations.

### Main Class
- **Methods:**
  - `main(String[] args)`: The main method that provides a console-based user interface for interacting with the system.

## How to Run

1. **Compile the Java files:**
   ```bash
   javac Room.java Reservation.java Payment.java Hotel.java Main.java
