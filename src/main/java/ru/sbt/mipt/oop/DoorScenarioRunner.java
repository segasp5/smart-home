package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorScenarioRunner implements EventHandler {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)) return;
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    //if door opens, turn on lights in the room
                    if (event.getType() == DOOR_OPEN) {
                        for (Light light : room.getLights()) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        }
                    }
                }
            }
        }
    }
}