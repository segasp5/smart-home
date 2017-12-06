package ru.sbt.mipt.oop;

/**
 * Created by user8 on 17.11.2017.
 */
public class AlarmSystem implements AlarmSystemState {

    private AlarmSystemState alarmSystemState;

    public AlarmSystem()
    {
        alarmSystemState = new AlarmSystemStateOff(this);
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
    public void turnOff() {
        alarmSystemState.turnOff();
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystemState.onEvent(sensorEvent);
    }

    @Override
    public void enterPassword(String password) {
        alarmSystemState.enterPassword(password);
    }

    public void setAlarmSystemState(AlarmSystemState alarmSystemState){
        this.alarmSystemState = alarmSystemState;
    }
}
