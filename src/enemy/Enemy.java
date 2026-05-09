// =========================
// Enemy.java
// =========================
package enemy;

import character.Character;

import java.util.Random;

public class Enemy {

    private String name;
    private int hp;
    private int attack;
    private int rewardExp;
    private boolean enraged;
    private boolean poisoned;


    public Enemy(String name, int hp, int attack, int rewardExp) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.rewardExp = rewardExp;
        this.enraged = false;
        this.poisoned = false;
    }

    public void takeDamage(int dmg) {

        hp -= dmg;

        if (hp < 0) {
            hp = 0;
        }

        System.out.println(name + " takes " + dmg + " damage!");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void applyPoisonDamage() {

        if (poisoned) {

            int poisonDamage = 10;

            hp -= poisonDamage;

            if (hp < 0) {

                hp = 0;
            }

            System.out.println("☠ " + name
                    + " takes "
                    + poisonDamage
                    + " poison damage!");
        }
    }

    public int attackTarget(Character target) {

        Random rand = new Random();

        int damage = rand.nextInt(11) + attack - 5;


        // =========================
        // DRAGON ENRAGE MODE
        // =========================

        if (name.equals("Dragon") && hp <= 100 && !enraged) {

            enraged = true;

            System.out.println("\n🔥 DRAGON ENRAGED!");
            System.out.println("⚠ Dragon's power increased!");
        }

        // เพิ่ม damage ตอน enraged
        if (enraged) {

            damage += 15;
        }

        System.out.println(name + " attacks for "
                + damage + " damage!");

        target.takeDamage(damage);

        return damage;
    }

    public void applyPoison() {

        poisoned = true;

        System.out.println(name + " is poisoned!");
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getRewardExp() {

        return rewardExp;
    }
}