// Guy Leib 316311190.

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Level3.
 *
 * @author - Guy Leib
 * version 1.0
 * since 19/06/2021
 * this class repsresnt the level 3 information.
 */
public class Level3 implements LevelInformation {
    private Sprite background = new BackGround3();
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;
    private int blockHeight = 30;
    private int blockWidth = 50;

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        this.initialBallVelocities = new ArrayList<Velocity>();
        for (int i = 1; i <= 2; i++) {
            this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(260 - i * 15, 10));
        }
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 25;
    }

    @Override
    public int paddleWidth() {
        return 300;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return background;
    }

    @Override
    public List<Block> blocks() {
        this.blocks = new ArrayList<Block>();
        Color color = Color.cyan;
        int y = 200;
        int x = 730;
        for (int i = 0; i < 40; i++) {
            if (i >= 0 && i < 10) {
                color = new Color(118, 136, 238);
                y = 140;
            }
            if (i >= 10 && i < 19) {
                color = new Color(250, 177, 105);
                y = 170;
                x = 1230;
            }
            if (i >= 19 && i < 26) {
                color = new Color(195, 121, 255);
                y = 200;
                x = 1680;
            }
            if (i >= 27 && i < 34) {
                color = new Color(237, 222, 116);
                y = 230;
                x = 2080;
            }
            if (i >= 34 && i < 40) {
                color = new Color(233, 126, 126);
                y = 260;
                x = 2430;
            }
            Block block = new Block(new Point(x - (i * 50), y), blockHeight, blockWidth, color);
            this.blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
