import java.util.InputMismatchException;
import java.util.Scanner;

public class GhostProfits {
  // Instanzvariablen

    static int killsPerHour;
    static int baseMagicFind;
    static int bestiaryTier;
    static double sorrowPrice;
    static boolean crownOfAvarice;
    static int[] bestiaryMagicFind = {2, 4, 6, 8, 10, 13, 16, 19, 22, 25, 29, 33, 37, 41, 45,
            50, 55, 60, 65, 70, 76, 82, 88, 94, 100};

    // Konstruktor

    public GhostProfits(int killsPerHour, int baseMagicFind, int bestiaryTier,
                        double sorrowPrice, boolean crownOfAvarice) {
        this.killsPerHour = killsPerHour;
        this.baseMagicFind = baseMagicFind;
        this.bestiaryTier = bestiaryTier;
        this.sorrowPrice = sorrowPrice;
        this.crownOfAvarice = crownOfAvarice;
    }

    public static void main(String[] args) {
        // Scanner für die Eingaben
        Scanner sc = new Scanner(System.in);

        try {
            // Eingaben einlesen
            System.out.println("Welcome to the Ghost Profit Calculator!");
            System.out.println("Enter the number of kills you average per hour: ");
            killsPerHour = sc.nextInt();

            System.out.println("Please enter your rounded magic find from your profile (ex. 302): ");
            baseMagicFind = sc.nextInt();

            System.out.println("Enter your bestiary tier in a number (1-25): ");
            bestiaryTier = sc.nextInt();

            System.out.println("Please write the price of a sorrow in coins: ");
            sorrowPrice = sc.nextDouble();

            System.out.println("Do you use a Crown of Avarice? (y/n): ");
            String crownInput = sc.next().toLowerCase();
            crownOfAvarice = crownInput.equals("y");
            sc.close();

            // Fehler abfangen und bei Fehler folgende Nachricht printen
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input! Please try again with the instructed format.");
        }
        // Ausgabe totalProfits
        double totalProfit = GhostCalculator.calculateTotalProfit(killsPerHour, baseMagicFind, bestiaryTier,
                sorrowPrice, crownOfAvarice);
        System.out.printf("Your total profit per hour: %, .2f coins%n", totalProfit);

        /*      System.out.println("Remember that this calculation assumes the following things" +
                "A Daedalus Axe with Looting V\n" +
                "Combat Wisdom of 120 (2.2x Multiplier)\n" +
                "1 Gdrag Pet XP is worth 2.1 Coins\n" +
                "You use a Gdrag with 50% XP boost and a second one with EXP share\n" +
                "You have a 1.8x Combat XP Multiplier due to Crimson Duping\n" +
                "Volta = 2750 Coins\n" +
                "Plasma = 20000 Coins\n" +
                "Ghostly Boots = 77777 Coins\n" +
                "A 3x Scavenged Coin Multiplier from a Crown of Avarice\n");
          */
    }
  }


