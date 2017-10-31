package ru.sbt.mipt.oop;

import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.sbt.mipt.oop.Application.configureHandlers;

public class TimeMeasuringEventTest {
    @Test
    public void run() {
        DoorScenarioRunner doorScenarioRunner = new DoorScenarioRunner();
        SmartHome smartHome = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId, false);
        String lightId1 = "1";
        String lightId2 = "2";
        List<Light> lights = new ArrayList<>();
        lights.add(new Light(lightId1, false));
        lights.add(new Light(lightId2, false));
        Room room = new Room(lights, Arrays.asList(door), "room");
        smartHome.addRoom(room);

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);

        TimeMeasuringEventHandler timeMeasuringEventHandler = new TimeMeasuringEventHandler(new DoorScenarioRunner());
        timeMeasuringEventHandler.handle(smartHome,event );

    }
}
