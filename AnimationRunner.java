import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * public class AnimationRunner.
 * @author - Guy Leib.
 * version 1.0
 * since 19/6/2021.
 * this class will run the animation of the gam..
 */
public class AnimationRunner {
    private GUI gui;
    private Sleeper sleeper;
    private int framesPerSecond = 60;
   private int millisecondsPerFrame = 1000 / framesPerSecond;

    /**
     * constructor.
     * @param gui - the gui.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.sleeper = new Sleeper();
    }

    /**
     * public void run.
     * this class will run the animation.
     * @param animation - the animation.
     */
    public void run(Animation animation) {
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper = new Sleeper();
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    return;
    }
}