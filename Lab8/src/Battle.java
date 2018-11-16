public class Battle extends Thread {
    private Instructor I1;
    private Instructor I2;
    private int time;

    /**
     * Take in two instructors and sets states to vales
     * @param I1 - First instructor
     * @param I2 - Second instructor
     */
    public Battle(Instructor I1, Instructor I2) {
        this.I1 = I1;
        this.I2 = I2;
    }

    /**
     * Will return the winning instructor
     * @return instructor with health > 0.
     */
    public Instructor getWinner() {
        if (I1.isAlive()) {
            return I1;
        }
        return I2;
    }

    /**
     * IDK
     */
    @Override
    public void run() {
        time = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                time++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((time % I1.getTimeToAtk()) == 0) {
                System.out.println("Time: " + time);
                System.out.println(I1.getName() + " attacks " + I2.getName());
                int dmg = I1.getAtkAmount();
                System.out.println(I1.getName() + " does " + dmg + " to " + I2.getName());
                I2.takeDamage(dmg);
                System.out.println(I2.toString() + "\n");
            }
            if ((time % I2.getTimeToAtk()) == 0) {
                System.out.println("Time: " + time);
                System.out.println(I2.getName() + " attacks " + I1.getName());
                int dmg = I2.getAtkAmount();
                System.out.println(I2.getName() + " does " + dmg + " to " + I1.getName());
                I1.takeDamage(dmg);
                System.out.println(I1.toString() + "\n");
            }
            if (I1.getHP() <= 0 || I2.getHP() <= 0) {
                System.out.println("The battle between " + I1.getName() + " and " + I2.getName() + " has ended!!!");
                if (getWinner().equals(I1)) {
                    System.out.println(getWinner().getName() + " has defeated " + I2.getName());
                } else {
                    System.out.println(getWinner().getName() + " has defeated " + I1.getName());
                }
                break;
            }

        }
    }
}
