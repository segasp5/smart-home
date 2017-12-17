package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

/**
 * Created by user6 on 13.10.2017.
 */
public class LightEventProcessor implements EventHandler, Actionable {


    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        System.out.println("\tIn LightEventProcessor");
        if (!(event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)) {
            System.out.println("\treturn");
            return;
        }
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
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
