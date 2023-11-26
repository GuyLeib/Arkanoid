//Guy Leib 316311190
/**
 * public interface HitNotifier.
 * @author - Guy Leib.
 * since 7/6/2021
 * version 1.0
 * this interface represent the HitNotifier in the game.
 */
public interface HitNotifier {
    /**
     *  void addHitListener.
     * @param hl - a hit listener to add.
     * this method add hl as a listener to hit events.
     */
    void addHitListener(HitListener hl);

    /**
     *  void removeHitListener.
     * @param hl - a hit listener to remove
     * this method remove hl from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}