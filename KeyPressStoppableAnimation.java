// Guy Leib 316311190.

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * class KeyPressStoppableAnimation.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 21/6/2021
 * this class will handle the case when a key was already pressed.
 */

public class KeyPressStoppableAnimation implements Animation {
    private boolean shouldClose;
    private boolean isAlreadyPressed;
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;


    /**
     * constructor.
     *
     * @param sensor    - the keyboard sensor.
     * @param key       - the pressed key.
     * @param animation - the animation.
     */

    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.shouldClose = false;
        this.isAlreadyPressed = true;
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (!this.sensor.isPressed(this.key)) {
            isAlreadyPressed = false;
        }
        if (!isAlreadyPressed && this.sensor.isPressed(this.key)) {
            shouldClose = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.shouldClose;
    }
}