import java.util.Scanner;

public class RockPaperScissors {
    static String computerChoice() {
        double r = Math.random();
        if (r < 0.33) return "Rock";
        else if (r < 0.66) return "Paper";
        else return "Scissors";
    }

    static String winner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("Rock") && comp.equals("Scissors")) return "User";
        if (user.equals("Scissors") && comp.equals("Paper")) return "User";
        if (user.equals("Paper") && comp.equals("Rock")) return "User";
        return "Computer";
    }

    static String[][] gameStats(int games, Scanner sc) {
        String[][] table = new String[games+1][3];
        int userWin = 0, compWin = 0, draws = 0;
        for (int i = 0; i < games; i++) {
            System.out.print("Game " + (i+1) + " - Enter Rock, Paper, or Scissors: ");
            String user = sc.next();
            String comp = computerChoice();
            String win = winner(user, comp);
            if (win.equals("User")) userWin++;
            else if (win.equals("Computer")) compWin++;
            else draws++;
            table[i][0] = user;
            table[i][1] = comp;
            table[i][2] = win;
        }
        table[games][0] = "Wins%";
        table[games][1] = "User: " + (userWin*100/games) + "%, Comp: " + (compWin*100/games) + "%, Draw: " + (draws*100/games) + "%";
        table[games][2] = "-";
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("User\tComputer\tWinner");
        for (int i = 0; i < table.length; i++)
            System.out.println(table[i][0] + "\t" + table[i][1] + "\t" + table[i][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        String[][] stats = gameStats(n, sc);
        displayTable(stats);
    }
}

