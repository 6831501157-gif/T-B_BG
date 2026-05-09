// =========================
// PowerSlash.java
// =========================
package skill;

public class PowerSlash implements Skill {

    private int power;
    private int manaCost;

    public PowerSlash() {
        power = 45;
        manaCost = 25;
    }

    @Override
    public int activate() {
        System.out.println("⚔ POWER SLASH! " +  manaCost +" ManaCost");
        return power;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }
}
