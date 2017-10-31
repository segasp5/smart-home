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

    static void configureHandlers(SensorEventObserver observer) {
        observer.addHandler(new TimeMeasuringEventHandler(new LightEventProcessor()));
        observer.addHandler(new TimeMeasuringEventHandler(new DoorEventProcessor()));
        observer.addHandler(new TimeMeasuringEventHandler(new DoorScenarioRunner()));
    }

    static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}