//Guy Leib 316311190.

/**
 * public class ScoreTrackingListener.
 * @author - Guy Leib.
 * since 7/6/2021
 * version 1.0
 * this class represent the ScoreTrackingListener in the game.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * public ScoreTrackingListener.
     * constructor.
     * @param scoreCounter - score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     *
     * @param beingHit - the block being hit.
     * @param hitter - the ball hitting the block
     * if the block got hit more than once, the method increase the score.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHits() > 0) {
            this.currentScore.increase(5);
        }
    }
}