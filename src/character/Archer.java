// =========================
// Archer.java
// =========================
package character;

import skill.PoisonArrow;
import skill.RapidShot;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 100, 25,70);

        critChance = 50;

        skills.add(new RapidShot());
        skills.add(new PoisonArrow());
    }

    @Override
    public int useSkill(int choice) {
        return skills.get(choice).activate();
    }
}
