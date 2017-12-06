package ru.sbt.mipt.oop;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user8 on 17.11.2017.
 */
public class AlarmSystemTests {

    @Test
    public void testNewSystemIsOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testTurnOnSetOnState(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void testSensorEventSetWait(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    private SensorEvent createSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1");
    }

    @Test
    public void testOnEventWhenSystemIsOff(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.onEvent(createSensorEvent());
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void testOnSystemGetsEventWithWrongPasswordGoesAlarm (){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();

        alarmSystem.onEvent(createSensorEvent());

        alarmSystem.enterPassword("123 ");

        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void testOnSystemGetsEventWithCorrectPasswordGoesOn (){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();

        alarmSystem.onEvent(createSensorEvent());

        alarmSystem.enterPassword("1234");

        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void testTurnOnDoesNothingWhenSystemIsWaiting(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.onEvent(createSensorEvent());

        alarmSystem.turnOn();

        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void testOnSystemTurnOffWithoutPassword (){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();

        alarmSystem.turnOff();

        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void testOnSystemTurnOffWithWrongPassword (){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();

        alarmSystem.turnOff();
        alarmSystem.enterPassword("123 ");

        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void testOnSystemTurnOffWithCorrectPassword (){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();

        alarmSystem.turnOff();
        alarmSystem.enterPassword("1234");

        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }



}
