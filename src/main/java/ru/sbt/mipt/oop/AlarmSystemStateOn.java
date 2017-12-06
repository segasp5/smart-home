package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.ON;
import static ru.sbt.mipt.oop.AlarmSystemStateEnum.OFF;


/**
 * Created by user8 on 17.11.2017.
 */
public class AlarmSystemStateOn implements AlarmSystemState {


    private AlarmSystem alarmSystem;


    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return ON;
    }

    @Override
    public void turnOn() {
        //do nothing
    }

    @Override
    public void turnOff() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWait(alarmSystem, OFF));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWait(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {
        //do nothing
    }
}
