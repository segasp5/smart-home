package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SmartHome implements Actionable {
    Collection<Room> rooms;


    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Light[] getLights() {
        List lights = new ArrayList();
        for (Room room : rooms) {
            lights.add(room.getLights());
        }
        return (Light[]) lights.toArray();
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }
}
