package org.example;

public class Room{
    public enum RoomStatus {ACTIVE, CLOSE, OPEN}

    private int id;
    private String name;
    private RoomStatus status ;


    public Room(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = RoomStatus.OPEN;
    }

    public void startGame(){
        this.status = RoomStatus.ACTIVE;
    }
    public void closeRoom()
    {
       this.status = RoomStatus.CLOSE;
    }
}
