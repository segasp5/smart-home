package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHome smartHome = readSmartHome.getSmartHome();
        SensorEventObserver sensorEventObserver = new SensorEventObserver(smartHome);
        configureHandlers(sensorEventObserver);
        sensorEventObserver.runEventCycle();

    }

    private static void configureHandlers(SensorEventObserver observer) {
        Collection<EventHandler> handlers = new ArrayList<>();
        observer.addHandler(new LightEventProcessor());
        observer.addHandler(new DoorEventProcessor());
        observer.addHandler(new DoorScenarioRunner());
    }

    protected static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}