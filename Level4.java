// Guy Leib 316311190

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Level4.
 *
 * @author - Guy Leib
 * version 1.0
 * since 19/06/2021
 * this class repsresnt the level 4 information.
 */
public class Level4 implements LevelInformation {
    private Sprite background = new BackGround4();
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;
    private int blockHeight = 30;
    private int blockWidth = 50;

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        this.initialBallVelocities = new ArrayList<Velocity>();
        for (int i = 1; i <= 3; i++) {
            this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(260 - i * 15, 10));
        }
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 50;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Final Four";
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
        int x = 725;
        for (int i = 0; i < 105; i++) {
            if (i >= 0 && i < 15) {
                color = new Color(61, 90, 133);
                y = 150;
            }
            if (i >= 15 && i < 30) {
                color = new Color(0, 105, 148);
                y = 180;
                x = 1475;
            }
            if (i >= 30 && i < 45) {
                color = new Color(8, 121, 142);
                y = 210;
                x = 2225;
            }
            if (i >= 45 && i < 60) {
                color = new Color(19, 153, 156);
                y = 240;
                x = 2975;
            }
            if (i >= 60 && i < 75) {
                color = new Color(98, 163, 178);
                y = 270;
                x = 3725;
            }
            if (i >= 75 && i < 90) {
                color = new Color(141, 182, 239);
                y = 300;
                x = 4475;
            }
            if (i >= 90 && i < 105) {
                color = new Color(173, 203, 241);
                y = 330;
                x = 5225;
            }
            Block block = new Block(new Point(x - (i * 50), y), blockHeight, blockWidth, color);
            this.blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
