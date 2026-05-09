package skill;

public class Berserk implements Skill {

    private int power;
    private int manaCost;

    public Berserk() {

        power = 80;
        manaCost = 25;
    }

    @Override
    public int activate() {

        System.out.println("🔥 BERSERK MODE!");
        return power;
    }

    @Override
    public int getManaCost() {

        return manaCost;
    }
}