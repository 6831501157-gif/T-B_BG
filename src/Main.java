// =========================
// Main.java
// =========================
import java.util.Scanner;

import battle.BattleSystem;
import character.Warrior;
import character.Mage;
import character.Archer;
import character.Character;

import enemy.Enemy;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== TURN-BASED BATTLE GAME =====");

        String name = "";

        // =========================
        // VALIDATE NAME
        // =========================
        while (true) {

            System.out.print("Enter your name: ");
            name = sc.nextLine();

            // ห้ามว่าง
            if (name.isEmpty()) {
                System.out.println("❌ Name cannot be empty!");
                continue;
            }

            // ห้ามมีอักษรพิเศษ
            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("❌ Name must contain only letters!");
                continue;
            }

            break;
        }

        int choice = 0;

        // =========================
        // VALIDATE CHARACTER CHOICE
        // =========================
        while (true) {

            try {

                System.out.println("\nChoose Character:");
                System.out.println("1. Warrior");
                System.out.println("2. Mage");
                System.out.println("3. Archer");

                System.out.print("Enter choice: ");

                choice = Integer.parseInt(sc.nextLine());

                // กันเลขติดลบ / เกิน
                if (choice < 1 || choice > 3) {
                    System.out.println("❌ Please enter 1-3 only!");
                    continue;
                }

                break;

            } catch (Exception e) {

                System.out.println("❌ Invalid input! Please enter numbers only.");
            }
        }

        Character player;

        switch (choice) {

            case 1:
                player = new Warrior(name);
                break;

            case 2:
                player = new Mage(name);
                break;

            case 3:
                player = new Archer(name);
                break;

            default:
                System.out.println("❌ Invalid choice!");
                return;
        }

        int stage = 1;

        while (true) {

            Enemy enemy;

            // =========================
            // STAGE SYSTEM
            // =========================

            if (stage == 1) {

                enemy = new Enemy(
                        "Goblin",
                        80,
                        10,
                        50);

            } else if (stage == 2) {

                enemy = new Enemy(
                        "Orc",
                        150,
                        20,
                        100);

            } else {

                enemy = new Enemy(
                        "Dragon",
                        250,
                        30,
                        200);
            }

            System.out.println("\n====================");
            System.out.println("🔥 STAGE " + stage);
            System.out.println("Enemy: " + enemy.getName());
            System.out.println("====================");

            BattleSystem battle = new BattleSystem();

            boolean win = battle.startBattle(player, enemy);

            // =========================
            // GAIN EXP
            // =========================

            if (win) {

                player.gainExp(enemy.getRewardExp());
            }

            // =========================
            // LOSE
            // =========================

            if (!win) {

                System.out.println("\n💀 You Lost...");
                System.out.println("🔄 Returning to Stage 1");

                player.fullHeal();
                player.recoverMana();

                stage = 1;

            } else {

                // =========================
                // NEXT STAGE
                // =========================

                stage++;

                // CLEAR GAME
                if (stage > 3) {

                    System.out.println("\n🏆 ALL STAGES CLEARED!");
                    System.out.println("🎉 YOU DEFEATED THE DRAGON!");
                    System.out.println("🔥 NEW GAME STARTING...\n");

                    break;
                }
            }
        }
    }
}
