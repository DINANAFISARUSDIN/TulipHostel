package Tulip.Assignments.Room;

public class Room {
    private String roomNo;
    private String block;
    private String furnitureCapacity;
    private int occupied;
    private int available;

    public Room() {}

    public Room(String roomNo, String block, String furnitureCapacity, int occupied, int available) {
        this.roomNo = roomNo;
        this.block = block;
        this.furnitureCapacity = furnitureCapacity;
        this.occupied = occupied;
        this.available = available;
    }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getBlock() { return block; }
    public void setBlock(String block) { this.block = block; }

    public String getFurnitureCapacity() { return furnitureCapacity; }
    public void setFurnitureCapacity (String furnitureCapacity) { this.furnitureCapacity = furnitureCapacity; }

    public int getOccupied() { return occupied; }
    public void setOccupied(int occupied) { this.occupied = occupied; }

    public int getAvailable() { return available; }
    public void setAvailable(int available) { this.available = available; }
}