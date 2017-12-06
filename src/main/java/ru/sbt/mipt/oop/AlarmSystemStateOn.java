package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.ON;

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

    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWait(alarmSystem));
    }
}
