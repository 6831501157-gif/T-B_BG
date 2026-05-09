// =========================
// Warrior.java
// =========================
package character;

import skill.Berserk;
import skill.PowerSlash;

public class Warrior extends Character {



    public Warrior(String name) {

        super(name, 180, 30, 40);

        skills.add(new PowerSlash());
        skills.add(new Berserk());
    }

    @Override
    public int useSkill(int choice) {
        return skills.get(choice).activate();
    }
}
