//Guy Leib 316311190.

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Level2.
 *
 * @author - Guy Leib
 * version 1.0
 * since 19/06/2021
 * this class repsresnt the level 2 information.
 */
public class Level2 implements LevelInformation {
    private Sprite background = new BackGround2();
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;
    private int blockHeight = 30;
    private int blockWidth = 50;
    private Velocity velocity = new Velocity(1, 1);

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        this.initialBallVelocities = new ArrayList<Velocity>();
        for (int i = 1; i <= 10; i++) {
            this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(260 - i * 15, 10));
        }
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        this.blocks = new ArrayList<Block>();
        Color color = Color.cyan;
        for (int i = 0; i < 15; i++) {
            if (i >= 2 && i < 4) {
                color = new Color(193, 227, 254);
            }
            if (i >= 4 && i < 6) {
                color = new Color(207, 182, 229);
            }
            if (i >= 6 && i < 10) {
                color = new Color(255, 238, 205);
            }
            if (i >= 10 && i < 12) {
                color = new Color(201, 222, 206);
            }
            if (i >= 12 && i < 14) {
                color = new Color(186, 219, 202);
            }
            if (i >= 14) {
                color = new Color(164, 169, 167);
            }
            Block block = new Block(new Point(i * 50 + 25, 200), blockHeight, blockWidth, color);
            this.blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
