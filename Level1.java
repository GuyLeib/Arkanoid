//Guy Leib 316311190.
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Level1.
 * @author - Guy Leib
 * version 1.0
 * since 19/06/2021
 * this class repsresnt the level 1 information.
 */
public class Level1 implements LevelInformation {
    private Sprite background = new BackGround1();
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;
    private int blockHeight = 90;
    private int blockWidth = 90;


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.initialBallVelocities.add(new Velocity(0.2, -8));
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        this.blocks = new ArrayList<Block>();
        Block block = new Block(new Point(335, 125), blockHeight, blockWidth, Color.red);
        this.blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
