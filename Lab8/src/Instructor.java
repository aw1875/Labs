import java.util.*;

public class Instructor {
    private String name;
    private int maxHP;
    private int minAtk;
    private int maxAtk;
    private int timeToAtk;
    private int currentHP;


    /**
     * Take in values for the private states and set them to those values
     *
     * @param name
     * @param maxHP
     * @param minAtk
     * @param maxAtk
     * @param timeToAtk
     */
    public Instructor(String name, int maxHP, int minAtk, int maxAtk, int timeToAtk) {
        this.name = name;
        this.maxHP = maxHP;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.timeToAtk = timeToAtk;
        this.currentHP = maxHP;
    }

    /**
     * Will return the name
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Will return the current HP
     *
     * @return currentHP
     */
    public int getHP() {
        return this.currentHP;
    }

    /**
     * Will return a random int between the minAtk and maxAtk values
     *
     * @return random int
     */
    public int getAtkAmount() {
        Random rand = new Random();
        return rand.nextInt(this.maxAtk - this.minAtk) + this.minAtk;
    }

    /**
     * Will return the timeToAtk
     *
     * @return timeToAtk
     */
    public int getTimeToAtk() {
        return this.timeToAtk;
    }

    /**
     * Wukk take in an integer amount of damage, decrease the hp by that amount, and return nothing
     *
     * @param dmg - damage taken
     */
    public void takeDamage(int dmg) {
        this.currentHP -= dmg;
    }

    /**
     * Will return true if the hp is greater than zero; false otherwise.
     *
     * @return true if hp > 0; false otherwise
     */
    public boolean isAlive() {
        if (this.currentHP > 0) {
            return true;
        }
        return false;
    }

    /**
     * Will reset the hp to maximum and return nothing
     */
    public void resetHP() {
        this.currentHP = this.maxHP;
    }

    /**
     * Will return string in the form of Name: CurrentHp hp, minAtk - maxAtk atk
     *
     * @return string of instructor with all values
     */
    public String toString() {
        return this.name + ": " + this.currentHP + " hp, " + this.minAtk + " - " + this.maxAtk + " atk";
    }
}
