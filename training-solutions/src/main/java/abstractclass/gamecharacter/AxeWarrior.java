package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character{

    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (getPosition().getDistance(enemy.getPosition()) < 2) {
            enemy.hit(this, getActualSecondaryDamage());
        }
    }

    private int getActualSecondaryDamage() {
        int bound = (getActualPrimaryDamage() * 2) + 1;
        return getRandom().nextInt(1,bound);
    }
}
