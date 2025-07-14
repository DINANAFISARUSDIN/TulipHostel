package Tulip.Assignments.Room;

public class Room {
    private String roomNo;
    private String block;
    private String furniture;
    private int capacity;
    private int occupied;
    private int available;

    public Room() {}

    public Room(String roomNo, String block, String furniture, int capacity, int occupied) {
        this.roomNo = roomNo;
        this.block = block;
        this.furniture = furniture;
        this.capacity = capacity;
        this.occupied = occupied;
        this.available = capacity - occupied;
    }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getBlock() { return block; }
    public void setBlock(String block) { this.block = block; }

    public String getFurniture() { return furniture; }
    public void setFurniture(String furniture) { this.furniture = furniture; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getOccupied() { return occupied; }
    public void setOccupied(int occupied) { this.occupied = occupied; }

    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = available; }
}