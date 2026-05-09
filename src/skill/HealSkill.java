// =========================
// HealSkill.java
// =========================
package skill;

public class HealSkill implements Skill {

    private int healAmount;
    private int manaCost;

    public HealSkill() {
        healAmount = 40;
        manaCost = 15;
    }

    @Override
    public int activate() {
        System.out.println("💚 HEAL! " +  manaCost +" ManaCost");
        return -healAmount;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }
}
