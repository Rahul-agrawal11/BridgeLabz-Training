import java.util.Random;

public class SnakeAndLadderGame {

    static final int NO_PLAY = 0;
    static final int LADDER = 1;
    static final int SNAKE = 2;
    static final int WINNING_POSITION = 100;

    static Random random = new Random();

    // UC 2 : Method to roll die
    public static int rollDie() {
        return random.nextInt(6) + 1;
    }

    // UC 3 : Method to get option
    public static int getOption() {
        return random.nextInt(3); // 0,1,2
    }

    public static void main(String[] args) {

        // UC 1 : Initialize players at start position 0
        int player1Pos = 0;
        int player2Pos = 0;
        int diceCount = 0;
        boolean isPlayer1Turn = true;

        System.out.println("Snake and Ladder Game Started!");

        // UC 4 & UC 5: Repeat till one player reaches position 100
        while (player1Pos < WINNING_POSITION && player2Pos < WINNING_POSITION) {
            
            // UC 2 : Player rolls the die
            int die = rollDie();

            // UC : 3 Player checks for option
            int option = getOption();
            diceCount++;

            if (isPlayer1Turn) {
                System.out.println("\nPlayer 1 rolled: " + die);

                player1Pos = movePlayer(player1Pos, die, option);
                System.out.println("Player 1 position: " + player1Pos);

                // Extra chance if Ladder
                if (option != LADDER) {
                    isPlayer1Turn = false;
                }

            } else {
                System.out.println("\nPlayer 2 rolled: " + die);

                player2Pos = movePlayer(player2Pos, die, option);
                System.out.println("Player 2 position: " + player2Pos);

                // Extra chance if Ladder
                if (option != LADDER) {
                    isPlayer1Turn = true;
                }
            }
        }

        // UC 6 : Report number of dice rolls
        System.out.println("\nGame Over!");
        System.out.println("Total Dice Rolls: " + diceCount);

        // UC 7 : Declare winner
        if (player1Pos == WINNING_POSITION) {
            System.out.println("Player 1 Wins!");
        } else {
            System.out.println("Player 2 Wins!");
        }
    }

    // UC 3, UC 4 & UC 5 : Player movement logic
    public static int movePlayer(int position, int die, int option) {

        switch (option) {
            case NO_PLAY:
                // No movement
                break;

            case LADDER:
                position += die;
                break;

            case SNAKE:
                position -= die;
                break;
        }

        // UC 4 : If position goes below 0, restart from 0
        if (position < 0) {
            position = 0;
        }

        // UC 5 : Ensure exact winning position 100
        if (position > WINNING_POSITION) {
            position -= die; // stay in previous position
        }

        return position;
    }
}