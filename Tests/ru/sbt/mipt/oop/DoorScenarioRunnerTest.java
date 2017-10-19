package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DoorScenarioRunnerTest {

    public boolean allLightsAreOn(Room room){
        for (Light light : room.getLights()) {
            if(!light.isOn()) { return false; }
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        DoorScenarioRunner doorScenarioRunner = new DoorScenarioRunner();
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId, false);
        String lightId1 = "1";
        String lightId2 = "2";
        List<Light> lights = new ArrayList<>();
        lights.add(new Light(lightId1, false));
        lights.add(new Light(lightId2, false));
        Room room = new Room(lights, Arrays.asList(door), "room");
        home.addRoom(room);
        assertFalse(allLightsAreOn(room));

        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        doorScenarioRunner.handle(home, event);
        assertTrue(allLightsAreOn(room));
    }

}