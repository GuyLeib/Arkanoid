//Guy Leib 316311190.

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * public class GameFlow.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021.
 * this class will be incharge of the game flow - moving between levels.
 * this class will also be in charge of calling the end screen in the right time.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private int horizontalBound;
    private int verticalBound;
    private Counter score;

    /**
     * constructor.
     *
     * @param ar              - animation runner.
     * @param ks              - the keyboard senesor.
     * @param numOfLives      - number of lives in the game. we wont use it.
     * @param horizontalBound - the width of the screen.
     * @param verticalBound   - the height of the screen.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, int numOfLives,
                    int horizontalBound, int verticalBound) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.horizontalBound = horizontalBound;
        this.verticalBound = verticalBound;
        this.score = new Counter();
    }

    /**
     * public void runLevels.
     * this class will be in charge of switching the levels and calling the end screen in the right time.
     *
     * @param levels - a list of the levels in the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        PauseScreen pause = new PauseScreen(this.keyboardSensor);
        KeyPressStoppableAnimation kpsPause = new KeyPressStoppableAnimation(this.keyboardSensor,
                this.keyboardSensor.SPACE_KEY, pause);
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);
            level.initialize();

            while (level.ballCount() > 0 && level.blockCount() > 0) {
                level.run();
                if (this.keyboardSensor.isPressed("p")) {
                    this.animationRunner.run(kpsPause);
                }
            }
            if (levels.indexOf(levelInfo) == levels.size() - 1 && level.blockCount() == 0) {
                EndScreen win = new EndScreen(this.score, keyboardSensor, "win");
                KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(this.keyboardSensor,
                        this.keyboardSensor.SPACE_KEY, win);
                while (!kps.shouldStop()) {
                    this.animationRunner.run(kps);
                }
            }
            if (level.ballCount() == 0) {
                EndScreen lost = new EndScreen(this.score, keyboardSensor, "lose");
                KeyPressStoppableAnimation kps = new KeyPressStoppableAnimation(this.keyboardSensor,
                        this.keyboardSensor.SPACE_KEY, lost);
                while (!kps.shouldStop()) {
                    this.animationRunner.run(kps);
                }
                break;
            }

        }
    }
}