package ru.sbt.mipt.oop;

public class TimeMeasuringEventHandler implements EventHandler {

    private EventHandler eventHandler;

    public TimeMeasuringEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void handle(SmartHome smartHome, SensorEvent event) {
        long start = System.nanoTime();
        System.out.println("start handling");
        eventHandler.handle(smartHome, event);
        long end = System.nanoTime();
        System.out.println("finish handling");
        System.out.println("t = " + (end - start)/1000 + " mks -----------  " + event + "\n");
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
