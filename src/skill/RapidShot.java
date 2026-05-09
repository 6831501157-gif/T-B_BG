package skill;

public class RapidShot implements Skill {

    private int power;
    private int manaCost;

    public RapidShot() {

        power = 50;
        manaCost = 15;
    }

    @Override
    public int activate() {

        System.out.println("🏹 RAPID SHOT!");
        return power;
    }

    @Override
    public int getManaCost() {

        return manaCost;
    }
}
