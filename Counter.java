//Guy Leib 316311190.

/**
 * public class Counter.
 * @author - Guy Leib
 * since 7/6/2021
 * version 1.0
 * this class represent the counters in the game.
 */
public class Counter {
    private int value;

    /**
     * constructor.
     */
    public Counter() {
        this.value = 0;
    }

    /**
     * void increase.
     *
     * @param number - the number to add.
     *               this method add number to current count.
     */
    void increase(int number) {
        this.value += number;

    }

    /**
     * void decrease.
     *
     * @param number - the number to subtract.
     *               subtract number from current count.
     */
    void decrease(int number) {
        this.value -= number;

    }

    /**
     * int getValue.
     *
     * @return - the current count.
     */
    int getValue() {
        return this.value;
    }
}