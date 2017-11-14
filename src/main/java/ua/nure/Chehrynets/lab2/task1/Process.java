package ua.nure.Chehrynets.lab2.task1;

public class Process {

    private static final String NAME_ONE = "Philosopher 1";
    private static final String NAME_TWO = "Philosopher 2";
    private static final String NAME_THREE = "Philosopher 3";
    private static final String NAME_FOUR = "Philosopher 4";
    private static final String NAME_FIVE = "Philosopher 5";


    /**
     * test task1
     */
    public static void main(String[] args) {
        working();
    }

    private static void working() {
        Fork forkOne = new Fork();
        Fork forkTwo = new Fork();
        Fork forkThree = new Fork();
        Fork forkFour = new Fork();
        Fork forkFive = new Fork();

        Thread philosopherOne = new Philosopher(forkFive, forkOne);
        philosopherOne.setName(NAME_ONE);
        Thread philosopherTwo = new Philosopher(forkOne, forkTwo);
        philosopherTwo.setName(NAME_TWO);
        Thread philosopherThree = new Philosopher(forkThree, forkTwo);
        philosopherThree.setName(NAME_THREE);
        Thread philosopherFour = new Philosopher(forkThree, forkFour);
        philosopherFour.setName(NAME_FOUR);
        Thread philosopherFive = new Philosopher(forkFive, forkFour);
        philosopherFive.setName(NAME_FIVE);

        philosopherOne.start();
        philosopherTwo.start();
        philosopherThree.start();
        philosopherFour.start();
        philosopherFive.start();
    }


}
