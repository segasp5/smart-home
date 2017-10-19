package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class DoorEventProcessorTest {

    @Test
    public void setDoor() throws Exception {
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId, false);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door), "room"));
        assertFalse(door.isOpen());
    }

    @Test
    public void makeClosedDoorOpen() throws Exception {
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId, false);
        home.addRoom(new Room(Collections.emptyList(), Arrays.asList(door), "room"));

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        doorEventProcessor.handle(home, event);
        assertTrue(door.isOpen());
    }
}