package ru.sbt.mipt.oop;

/**
 * Created by user8 on 17.11.2017.
 */
public interface AlarmSystemState {

    AlarmSystemStateEnum getState();

    void turnOn();

    void turnOff();

    void onEvent(SensorEvent sensorEvent);

    void enterPassword(String password);
}
