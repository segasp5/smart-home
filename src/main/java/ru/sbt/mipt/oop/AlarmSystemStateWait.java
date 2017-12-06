package ru.sbt.mipt.oop;

public class AlarmSystemStateWait implements AlarmSystemState {

    private AlarmSystem alarmSystem;

    public AlarmSystemStateWait(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {

    }
}
