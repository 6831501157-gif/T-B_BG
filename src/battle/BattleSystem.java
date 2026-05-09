// =========================
// BattleSystem.java
// =========================
package battle;

import java.util.Scanner;
import skill.Skill;

import character.Character;
import enemy.Enemy;

public class BattleSystem {

    Scanner sc = new Scanner(System.in);

    public boolean startBattle(Character player, Enemy enemy) {

        while (player.isAlive() && enemy.isAlive()) {

            showStatus(player, enemy);

            boolean validTurn = playerTurn(player, enemy);

            if (validTurn && enemy.isAlive()) {

                enemyTurn(player, enemy);
            }

        }

        if (player.isAlive()) {

            System.out.println("\n🏆 STAGE CLEARED!");
            return true;

        } else {

            System.out.println("\n💀 GAME OVER!");
            return false;
        }
    }

    public boolean playerTurn(Character player, Enemy enemy) {

        System.out.println("\n1. Basic Attack");
        System.out.println("2. Use Skill");
        System.out.println("3. Use Potion");

        int choice;

        // =========================
        // VALIDATE INPUT
        // =========================
        try {

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

        } catch (Exception e) {

            System.out.println("❌ Please enter numbers only!");
            return false;
        }

        // =========================
        // CONFIRM ACTION
        // =========================

        System.out.print("Confirm action? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")
                && !confirm.equalsIgnoreCase("y")) {

            System.out.println("❌ Action cancelled!");
            return false;
        }

        switch (choice) {

            case 1:

                int damage = player.basicAttack();

                enemy.takeDamage(damage);

                return true;

            case 2:

                System.out.println("\nChoose Skill:");

                for (int i = 0; i < player.getSkills().size(); i++) {

                    System.out.println((i + 1) + ". "
                            + player.getSkills().get(i).getClass().getSimpleName());
                }

                int skillChoice = sc.nextInt() - 1;

                if (skillChoice < 0 ||
                        skillChoice >= player.getSkills().size()) {

                    System.out.println("❌ Invalid skill choice!");
                    return false;
                }

                Skill selectedSkill =
                        player.getSkills().get(skillChoice);

                if (!player.useMana(selectedSkill.getManaCost())) {

                    System.out.println("❌ Not enough mana!");
                    return false;
                }

                int result = player.useSkill(skillChoice);
                if (player.getSkills()
                        .get(skillChoice)
                        .getClass()
                        .getSimpleName()
                        .equals("PoisonArrow")) {

                    enemy.applyPoison();
                }

                if (result < 0) {

                    player.heal(-result);

                } else {

                    enemy.takeDamage(result);
                }

                return true;

            case 3:

                System.out.println("\n🧪 POTION MENU");
                System.out.println("1. Health Potion ("
                        + player.getHealthPotion() + ")");
                System.out.println("2. Mana Potion ("
                        + player.getManaPotion() + ")");

                int potionChoice = sc.nextInt();

                if (potionChoice == 1) {

                    player.useHealthPotion();

                } else if (potionChoice == 2) {

                    player.useManaPotion();

                } else {

                    System.out.println("❌ Invalid potion choice!");
                    return false;
                }

                return true;

            default:

                System.out.println("❌ Invalid choice!");
                return false;
        }
    }

    public void enemyTurn(Character player, Enemy enemy) {

        enemy.applyPoisonDamage();

        // ถ้าตายจากพิษ
        if (!enemy.isAlive()) {

            return;
        }

        System.out.println();

        enemy.attackTarget(player);
    }

    public void showStatus(Character player, Enemy enemy) {

        System.out.println("\n=======================");
        System.out.println(player.getName() + " HP: " + player.getHp() + "/" + player.getMaxHp() + " MANA: " + player.getMana() + "/" + player.getMaxMana());
        System.out.println(enemy.getName() + " HP: " + enemy.getHp());
        System.out.println("=======================");
    }
}
