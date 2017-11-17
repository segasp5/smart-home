package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.*;

/**
 * Created by user8 on 17.11.2017.
 */
public class AlarmSystem implements AlarmSystemState {

    private AlarmSystemState alarmSystemState;

    public AlarmSystem()
    {
        alarmSystemState = new AlarmSystemStateOff(this);
        //systemStateEnum = OFF;
    }

    @Override
    public AlarmSystemStateEnum getState() {

        return alarmSystemState.getState();
    }

    @Override
    public void turnOn() {
        alarmSystemState.turnOn();

    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystemState.onEvent(sensorEvent);

    }

    public void setAlarmSystemState(AlarmSystemState alarmSystemState){
        this.alarmSystemState = alarmSystemState;
    }
}
