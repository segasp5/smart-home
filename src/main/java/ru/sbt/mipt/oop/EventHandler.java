package ru.sbt.mipt.oop;

/**
 * Created by user6 on 13.10.2017.
 */
public interface EventHandler {
    void handle(SmartHome smartHome, SensorEvent event);
}
