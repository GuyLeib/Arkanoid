// Guy Leib 316311190.

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * public class Game.
 *
 * @author - Guy Leib.
 * version 2.0
 * since 7/6/2021
 * this class initalize and runs the GameLevelanimation.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment gameEnvironment;
    private static int screenWidth = 800;
    private static int screenHeight = 600;
    private GUI gui;
    private Velocity ve;
    private List<HitListener> hitListeners;
    private Counter remainingBlcoks = new Counter();
    private Counter remainingBalls = new Counter();
    private Counter score;
    private ScoreIndicator scoreIndicator;
    private ScoreTrackingListener scoreTracking;
    private List<Block> blocks = new ArrayList<Block>();
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;
    private AnimationRunner animationRunner;


    /**
     * public Game.
     * this method construct a new game.
     *
     * @param animationRunner  - the animation runner.
     * @param keyboardSensor   - the keyboard sensor.
     * @param levelInformation - the level information.
     * @param score            - the current score.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor, AnimationRunner animationRunner,
                     Counter score) {
        this.gameEnvironment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.keyboard = keyboardSensor;
        this.level = levelInformation;
        this.animationRunner = animationRunner;
        this.score = score;
        this.scoreIndicator = new ScoreIndicator(this.score);
        this.scoreTracking = new ScoreTrackingListener(this.score);
    }

    /**
     * public void addCollidable.
     *
     * @param c - the collidable needs to be added.
     */
    public void addCollidable(Collidable c) {
        this.gameEnvironment.addCollidable(c);

    }

    /**
     * public void addSprite.
     *
     * @param s - the sprite needs to be added.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);

    }

    /**
     * public void initialize().
     * this method will create the Blocks ,Balls and Paddle.
     * this method will add them to the game.
     */
    public void initialize() {
        // create the paddle.
        if (this.level.getBackground() != null) {
            sprites.addSprite(this.level.getBackground());
        }
        Paddle pad = new Paddle(screenWidth, screenHeight, this.keyboard,
                Color.darkGray, this.level.paddleSpeed(), this.level.paddleWidth());
        pad.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, this.remainingBalls);
        //create the margins.
        Block upper = new Block(new Point(0, 0), 20, screenWidth, Color.cyan);
        Block deathBlock = new Block(new Point(20, screenHeight - 20), 20, screenWidth - 40, Color.black);
        Block left = new Block(new Point(0, 20), screenHeight, 20, Color.cyan);
        Block right = new Block(new Point(screenWidth - 20, 20), screenHeight, 20, Color.cyan);
        deathBlock.addHitListener(ballRemover);
        upper.addToGame(this);
        deathBlock.addToGame(this);
        left.addToGame(this);
        right.addToGame(this);
        scoreIndicator.addToGame(this);
        LevelName name = new LevelName(this.level.levelName());
        name.addToGame(this);

        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlcoks);
        for (Block b : this.level.blocks()) {
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTracking);
            b.addToGame(this);
        }
        this.remainingBlcoks.increase(this.level.numberOfBlocksToRemove());
      this.createBallsOnTopOfPaddle();
    }


    /**
     * public void run().
     * this method will run the GameLeveland start the animation loop.
     */
//    private AnimationRunner runner = new AnimationRunner(this.);
    public void run() {
        this.animationRunner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.animationRunner.run(this);
    }

    /**
     * private void createBallsOnTopOfPaddle.
     * this method create the balls according to the level information.
     * this method create the ball on top of the paddle.
     */
    private void createBallsOnTopOfPaddle() {
        // create the balls.
        this.remainingBalls.decrease(this.remainingBalls.getValue());
        // making sure that every level the counter equals to 0.
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(400, 500), 10, Color.pink,
                    this.level.initialBallVelocities().get(i), gameEnvironment);
            ball.addToGame(this);
        }
        this.remainingBalls.increase(this.level.numberOfBalls());
    }

    /**
     * public void removeCollidable.
     *
     * @param c - the collidable to remove.
     *          this method removes collidable from the game.
     */
    public void removeCollidable(Collidable c) {
        gameEnvironment.removeColliadable(c);
    }

    /**
     * public void removeCollidable.
     *
     * @param s - the sprite to remove.
     *          this method removes sprite from the sprite collection.
     */

    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.remainingBlcoks.getValue() == 0) {
            this.running = false;
        }
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.animationRunner.run(new PauseScreen(this.keyboard));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * public int ballCount.
     *
     * @return - the number of remaining balls in the game.
     */
    public int ballCount() {
        return this.remainingBalls.getValue();
    }

    /**
     * public int blockCount.
     *
     * @return - the number of remaining balls in the game.
     */
    public int blockCount() {
        return this.remainingBlcoks.getValue();
    }


}

