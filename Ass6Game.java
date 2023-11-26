// Guy Leib 316311190.

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * public class Ass6Game.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 7/6/2021
 * this class runs the game.
 */
public class Ass6Game {
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    private GUI gui = new GUI("Arkanoid", screenWidth, screenHeight);
    private AnimationRunner runner = new AnimationRunner(gui);

    /**
     * public static void main.
     *
     * @param args - no use at this main.
     *             this main calls the initialize and the run methods.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui);
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        for (String level : args) {
            if (level.equals("1")) {
                levels.add(new Level1());
            }
            if (level.equals("2")) {
                levels.add(new Level2());
            }
            if (level.equals("3")) {
                levels.add(new Level3());
            }
            if (level.equals("4")) {
                levels.add(new Level4());
            }
        }
        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        GameFlow game = new GameFlow(ar, gui.getKeyboardSensor(), 7, 800, 600);
        game.runLevels(levels);
        gui.close();
    }

}
