//Guy Leib 316311190

/**
 * public Class BallRemover.
 *
 * @author - Guy Leib.
 * since 7/6/2021
 * version 1.0
 * this class will remove the ball from the game when it hits the death wall.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game         - the game.
     * @param removedBalls - counter that holds the number of removedBalls.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
}
