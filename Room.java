enum RoomType {
    SINGLE, DOUBLE, SUITE
}

class Room {
    private int roomNumber;
    private RoomType type;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, RoomType type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type=" + type +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

