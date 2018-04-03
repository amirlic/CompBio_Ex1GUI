package core;

public class Main {

    /**
     * main class.
     *
     * @param args arguments.
     */
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.getOtomat().InitialOtomat();
        for (int i = 0; i < 20; i++) {
            logic.makeMove();
            logic.printBoard();
            System.out.println(" ");
        }
    }
}