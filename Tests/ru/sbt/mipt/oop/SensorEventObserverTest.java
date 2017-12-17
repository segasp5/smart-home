package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SensorEventObserverTest {

    @Test
    public void setHandlers() throws Exception {

        SmartHome smarthome = createSmartHome();
        SensorEventObserver observer = new SensorEventObserver(smarthome);

        List<EventHandler> handlers = new ArrayList<>();

        handlers.add(new LightEventProcessor());
        handlers.add(new DoorEventProcessor());

        observer.setHandlers(handlers);
        assertEquals(observer.getHandlers(), handlers);

    }

    @Test
    public void addHandler() throws Exception {

        SmartHome smarthome = createSmartHome();
        SensorEventObserver observer = new SensorEventObserver(smarthome);

        List<EventHandler> handlers = new ArrayList<>();

        handlers.add(new LightEventProcessor());
        handlers.add(new DoorEventProcessor());

        observer.setHandlers(handlers);

        DoorScenarioRunner doorScenarioRunner = new DoorScenarioRunner();

        handlers.add(doorScenarioRunner);
        observer.addHandler(doorScenarioRunner);
        assertEquals(observer.getHandlers(), handlers);

    }

    @Test
    public void visitAllHandlers() throws Exception {

        SmartHome smarthome = createSmartHome();
        SensorEventObserver observer = new SensorEventObserver(smarthome);

        List<EventHandler> handlers = new ArrayList<>();

        handlers.add(new LightEventProcessor());
        handlers.add(new DoorEventProcessor());
        handlers.add(new DoorScenarioRunner());

        observer.setHandlers(handlers);

        Set<Object> unvisitedHandlers = new HashSet<>(handlers);

        observer.executeAction(obj -> {
            unvisitedHandlers.remove(obj);
        });
        assertEquals(0, unvisitedHandlers.size());

    }

    private SmartHome createSmartHome() {
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId, false);
        home.addRoom(new Room(Collections.emptyList(), Collections.singletonList(door), "room"));
        return home;
    }

}