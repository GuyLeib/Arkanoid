//Guy Leib 316311190.

/**
 * public class BlockRemover.
 *
 * @author - Guy Leib
 * since 7/6/2021
 * version 1.0
 * this class  is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          - the game.
     * @param removedBlocks - a counter that holds how many block have removed.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     *  void hitEvent.
     * @param beingHit - the block being hit.
     * @param hitter - the ball hitting the block
     * This method is called whenever the beingHit object is hit.
     * this method will remove the block being hit from the game and sprite.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
        game.removeCollidable(beingHit);
        game.removeSprite(beingHit);
    }

}
