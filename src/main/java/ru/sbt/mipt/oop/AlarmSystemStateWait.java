package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.OFF;
import static ru.sbt.mipt.oop.AlarmSystemStateEnum.ON;

public class AlarmSystemStateWait implements AlarmSystemState {

    private AlarmSystem alarmSystem;
    private AlarmSystemStateEnum desiredState = null;

    public AlarmSystemStateWait(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
        this.desiredState = null;
    }

    public AlarmSystemStateWait(AlarmSystem alarmSystem, AlarmSystemStateEnum desiredState) {
        this.alarmSystem = alarmSystem;
        this.desiredState = desiredState;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }

    @Override
    public void turnOn() {
        //do nothing
    }

    @Override
    public void turnOff() {
        //do nothing
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        //do nothing
    }

    @Override
    public void enterPassword(String password) {
        if (password.equals("1234")) {
            //after an Event takes place
            if(this.desiredState == null) alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
            //turn off from ON and ALARM states
            if(this.desiredState == OFF) alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
            //Make ON from ALARM state after entering correct password
            if(this.desiredState == ON) alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
        }else{
            alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        }

    }
}
