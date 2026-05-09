// =========================
// Character.java
// =========================
package character;

import java.util.ArrayList;
import java.util.Random;
import skill.Skill;

public abstract class Character {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected int mana ;
    protected int exp;
    protected int level;
    protected int maxMana;
    protected int critChance;
    protected int healthPotion;
    protected int manaPotion;

    protected ArrayList<Skill> skills = new ArrayList<>();

    public Character(String name, int hp, int attack,int mana) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.mana = mana;
        this.maxMana = mana;
        this.exp = 0;
        this.level = 1;
        this.critChance = 20;
        this.healthPotion = 3;
        this.manaPotion = 2;
    }

    public int basicAttack() {

        Random rand = new Random();

        int damage = attack;

        if (rand.nextInt(100) < critChance) {

            damage *= 2;
            System.out.println("🔥 CRITICAL HIT!");
        }

        System.out.println(name + " attacks for " + damage + " damage!");

        return damage;
    }

    public void takeDamage(int dmg) {

        hp -= dmg;

        if (hp < 0) {
            hp = 0;
        }

        System.out.println(name + " takes " + dmg + " damage!");
    }

    public void heal(int amount) {

        hp += amount;

        // กันเลือดเกิน max
        if (hp > maxHp) {

            hp = maxHp;
        }

        System.out.println(name + " healed +" + amount + " HP");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public abstract int useSkill(int choice);

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxHp() {

        return maxHp;
    }

    public int getMaxMana() {

        return maxMana;
    }

    public int getHealthPotion() {

        return healthPotion;
    }

    public int getManaPotion() {

        return manaPotion;
    }

    public boolean useMana(int amount) {

        if (mana >= amount) {

            mana -= amount;
            return true;
        }

        return false;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void gainExp(int amount) {

        exp += amount;

        System.out.println(name + " gained "
                + amount + " EXP!");

        // LEVEL UP
        if (exp >= 100) {

            maxHp += 20;
            hp = maxHp;
            attack += 5;
            maxMana += 5;
            mana = maxMana;

            System.out.println("\n🔥 LEVEL UP!");
            System.out.println("Level: " + level);
            System.out.println("HP increased!");
            System.out.println("Attack increased!");
        }
    }

    public void fullHeal() {

        hp = maxHp;

        System.out.println(name + " fully recovered!");
    }

    public void recoverMana() {

        mana = maxMana;

        System.out.println(name + " mana fully recovered!");
    }

    public void useHealthPotion() {

        if (healthPotion <= 0) {

            System.out.println("❌ No Health Potions left!");
            return;
        }

        healthPotion--;

        heal(50);

        System.out.println("❤️ Used Health Potion!");
    }

    public void useManaPotion() {

        if (manaPotion <= 0) {

            System.out.println("❌ No Mana Potions left!");
            return;
        }

        manaPotion--;

        mana += 30;

        if (mana > maxMana) {

            mana = maxMana;
        }

        System.out.println("🔵 Used Mana Potion!");
    }

    public void resetPotions() {

        healthPotion = 3;
        manaPotion = 2;

        System.out.println("🧪 Potions replenished!");
    }
}
