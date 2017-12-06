package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.OFF;
import static ru.sbt.mipt.oop.AlarmSystemStateEnum.ON;

public class AlarmSystemStateAlarm implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemStateAlarm(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ALARM;
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
        //do nothing
    }

    @Override
    public void enterPassword(String password) {
        //ALARM stops, it becomes just ON
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWait(alarmSystem, ON));
    }
}
