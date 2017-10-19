package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by user6 on 13.10.2017.
 */
public class LightEventProcessorTest {
    @Test
    public void setLight() throws Exception {
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "room"));
        assertFalse(light.isOn());
    }

    @Test
    public void makeOffLightOn() throws Exception {
        LightEventProcessor lightEventProcessor = new LightEventProcessor();
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "room"));

        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
        lightEventProcessor.handle(home, event);
        assertTrue(light.isOn());
    }

}