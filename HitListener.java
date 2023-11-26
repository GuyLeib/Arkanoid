//Guy Leib 316311190
/**
 * public interface HitListener.
 * @author - Guy Leib.
 * since 7/6/2021
 * version 1.0
 * this interface represent the hitListener in the game.
 */
public interface HitListener {
    /**
     *  void hitEvent.
     * @param beingHit - the block being hit.
     * @param hitter - the ball hitting the block
     * This method is called whenever the beingHit object is hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}