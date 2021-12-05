package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character{

    private int numberOfArrow;

    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }

    public Archer(Point position, Random random) {
        super(position, random);
        this.numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    private int getActualSecondaryDamage() {
        return getRandom().nextInt(1,6);
    }

    private void shootingAnArrow(Character enemy) {
       numberOfArrow--;
       enemy.hit(this, getActualSecondaryDamage());
    }
}
