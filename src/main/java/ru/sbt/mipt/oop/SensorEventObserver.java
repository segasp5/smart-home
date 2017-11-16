package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by user6 on 27.10.2017.
 */
public class SensorEventObserver {

    private Collection<EventHandler> eventHandlers = new ArrayList<>();
    private SmartHome smartHome;

    public SensorEventObserver(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    public void runEventCycle() {
        EventProducer randomEventProducer = new RandomEventProducer();
        SensorEvent event = randomEventProducer.getNextSensorEvent();
        while (event != null) {
            System.out.println("\n\nEvent: " + event);

            for (EventHandler eventHandler : eventHandlers) {
                eventHandler.handle(smartHome, event);
            }

            event = randomEventProducer.getNextSensorEvent();
        }
    }

    public void addHandler(EventHandler eventHandler){
        eventHandlers.add(eventHandler);
    }

    public void setHandlers(List<EventHandler> handlers) {
        this.eventHandlers = handlers;
    }
}
