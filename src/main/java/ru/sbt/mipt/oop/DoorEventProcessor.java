package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by user6 on 13.10.2017.
 */
public class DoorEventProcessor implements EventHandler, Actionable {

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        System.out.println("\tIn DoorEventProcessor");
        if (!(event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)) {
            System.out.println("\treturn");
            return;
        }
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        AutoEventsProcessing.swichOffLightInEmptyHome(smartHome, room);
                    }
                }
            }
        }
    }


    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
