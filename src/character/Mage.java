// =========================
// Mage.java
// =========================
package character;

import skill.Fireball;
import skill.HealSkill;

public class Mage extends Character {

    private int mana;

    public Mage(String name) {

        super(name, 100, 15, 100);

        skills.add(new Fireball());
        skills.add(new HealSkill());
    }

    @Override
    public int useSkill(int choice) {
        return skills.get(choice).activate();
    }
}
