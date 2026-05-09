package skill;

public class PoisonArrow implements Skill {

    private int power;
    private int manaCost;

    public PoisonArrow() {

        power = 35;
        manaCost = 20;
    }

    @Override
    public int activate() {

        System.out.println("☠ POISON ARROW!");
        return power;
    }

    @Override
    public int getManaCost() {

        return manaCost;
    }
}