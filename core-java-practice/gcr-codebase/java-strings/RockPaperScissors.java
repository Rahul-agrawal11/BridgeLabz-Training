import java.util.Scanner;

class RockPaperScissors {

    // Get computer choice using Math.random()
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0)
            return "Rock";
        else if (choice == 1)
            return "Paper";
        else
            return "Scissors";
    }

    // Find winner between user and computer
    public static String findWinner(String user, String computer) {

        if (user.equalsIgnoreCase(computer)) {
            return "Draw";
        }

        if ((user.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
            (user.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
            (user.equalsIgnoreCase("Scissors") && computer.equals("Paper"))) {
            return "User";
        }

        return "Computer";
    }

    // Calculate wins and percentages
    public static String[][] calculateStats(int userWins, int compWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) compWins / totalGames) * 100;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f%%", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f%%", compPercent);

        return stats;
    }

    // Display game results and final statistics
    public static void displayResults(String[][] games, String[][] stats) {

        System.out.println("\nGame\tUser Choice\tComputer Choice\tWinner");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < games.length; i++) {
            System.out.println((i + 1) + "\t" +
                    games[i][0] + "\t\t" +
                    games[i][1] + "\t\t" +
                    games[i][2]);
        }

        System.out.println("\nFinal Statistics");
        System.out.println("Player\tWins\tWinning Percentage");
        System.out.println("--------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                    stats[i][1] + "\t" +
                    stats[i][2]);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = input.nextInt();
        input.nextLine();

        String[][] gameResults = new String[n][3];
        int userWins = 0, compWins = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = input.nextLine();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, compWins, n);
        displayResults(gameResults, stats);

        input.close();
    }
}