// =========================
// Fireball.java
// =========================
package skill;

public class Fireball implements Skill {

    private int power;
    private int manaCost;

    public Fireball() {
        power = 60;
        manaCost = 20;
    }

    @Override
    public int activate() {
        System.out.println("🔥 FIREBALL! " + manaCost +" ManaCost");
        return power;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }
}