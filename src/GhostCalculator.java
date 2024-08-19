public class GhostCalculator {

    // Berechnung für final Magic Find
    public static int calculateFinalMagicFind(int baseMagicFind, int bestiaryTier) {
        int finalMagicFind = baseMagicFind + GhostProfits.bestiaryMagicFind[bestiaryTier -1];
        return finalMagicFind;
    }

    // Berechnung für die scavenged Coins
    public static double calculateScavengedCoins(int killsPerHour, boolean crownOfAvarice, int bestiaryTier) {
        double baseCoins = 535 + (0.02 * bestiaryTier);
        double scavengedCoins = (baseCoins + 100) * killsPerHour;
        if (crownOfAvarice == true) {
            scavengedCoins *= 3;
        }
        return scavengedCoins;
    }

    // Berechnung für die Drops
    public static double calculateDropsPerHour(int killsPerHour, double finalMagicFind, double sorrowPrice) {
        double dropChanceMultiplier = 1 + (finalMagicFind / 100 * 1.75);

        // Dropchancen pro Kill
        double voltaChance = 0.002 * dropChanceMultiplier;
        double sorrowChance = 0.0012 * dropChanceMultiplier;
        double plasmaChance = 0.001 * dropChanceMultiplier;
        double bootsChance = 0.0001 * dropChanceMultiplier;

        // Durchschnittlicher Gewinn pro Stunde pro Drop-Typ
        double voltaProfit = voltaChance * killsPerHour * 2750;
        double sorrowProfit = sorrowChance * killsPerHour * sorrowPrice;
        double plasmaProfit = plasmaChance * killsPerHour * 20000;
        double bootsProfit = bootsChance * killsPerHour * 77777;

        // Gesamtgewinn pro Stunde
        return voltaProfit + sorrowProfit + plasmaProfit + bootsProfit;

    }

    // Berechnung für die Pet XP
    public static double calculateCoinsForLevel(int killsPerHour) {
        return killsPerHour * 2636.28;
    }

    // Berechnung gesamter Profits
    public static double calculateTotalProfit(int killsPerHour, int baseMagicFind, int bestiaryTier,
                                              double sorrowPrice, boolean crownOfAvarice) {

        double finalMagicFind = calculateFinalMagicFind(baseMagicFind, bestiaryTier);
        double scavengedCoins = calculateScavengedCoins(killsPerHour, crownOfAvarice, bestiaryTier);
        double dropsProfit = calculateDropsPerHour(killsPerHour, finalMagicFind, sorrowPrice);
        double petXPCoins = calculateCoinsForLevel(killsPerHour);

        return scavengedCoins + dropsProfit + petXPCoins;
    }
}
