//Guy Leib 316311190.

import java.util.List;

/**
 * public interface LevelInformation.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 12/6/2021
 * this interface represnt the levels information.
 */
public interface LevelInformation {
    /**
     * int numberOfBalls.
     *
     * @return - the number of balls in the level.
     */
    int numberOfBalls();

    /**
     * List<Velocity> initialBallVelocities.
     *
     * @return - a list that holds the initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * int paddleSpeed.
     *
     * @return - the paddle speed.
     */
    int paddleSpeed();

    /**
     * int paddleWidth.
     *
     * @return - the paddle width.
     */
    int paddleWidth();

    /**
     * String levelName.
     *
     * @return -the level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * Sprite getBackground.
     *
     * @return - Returns a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * List<Block> blocks.
     *
     * @return - a list of blocks that make up this level.
     */
    List<Block> blocks();


    /**
     * int numberOfBlocksToRemove.
     *
     * @return - the numbers of blocks in this level.
     */
    int numberOfBlocksToRemove();
}