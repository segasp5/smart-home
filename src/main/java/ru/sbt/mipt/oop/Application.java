package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = readSmartHome.getSmartHome();
        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();


        Collection<EventHandler> eventHandlers = configureHandlers();



        while (event != null) {

            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }
       /*
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                new LightsEventsProcessor().handle(event, smartHome);
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                DoorEventsProcessor.processDoorEvent(smartHome, event);
            }
        */
            event = getNextSensorEvent();
        }

    }

    private static Collection<EventHandler> configureHandlers() {
        Collection<EventHandler> handlers = new ArrayList<>();
        handlers.add(new LightEventProcessor());
        handlers.add(new DoorEventProcessor());
        handlers.add(new DoorScenarioRunner());
        return handlers;
    }

    protected static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
