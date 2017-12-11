package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Application {

    public static void main(String... args) throws IOException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        SensorEventObserver sensorEventObserver = (SensorEventObserver) ctx.getBean("sensorEventObserver");
        sensorEventObserver.runEventCycle();
        /*
        // считываем состояние дома из файла
        SmartHome smartHome = ReadSmartHome.formJSON();
        SensorEventObserver sensorEventObserver = new SensorEventObserver(smartHome);
        configureHandlers(sensorEventObserver);
        sensorEventObserver.runEventCycle();
*/
    }

    static void configureHandlers(SensorEventObserver observer) {
        List<EventHandler> handlers = new ArrayList<>();
        observer.addHandler(new LightEventProcessor());
        observer.addHandler(new DoorEventProcessor());
        observer.addHandler(new DoorScenarioRunner());
        observer.setHandlers(handlers);

        /*
        observer.addHandler(new TimeMeasuringEventHandler(new LightEventProcessor()));
        observer.addHandler(new TimeMeasuringEventHandler(new DoorEventProcessor()));
        observer.addHandler(new TimeMeasuringEventHandler(new DoorScenarioRunner()));
        */
    }

    static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}