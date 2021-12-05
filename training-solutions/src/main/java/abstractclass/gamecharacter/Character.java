package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private Point position;
    private int hitPoint = 100;
    private Random random;

    public Character(Point position, Random random) {
        this.position = position;
        this.random = random;
    }

    public abstract void secondaryAttack(Character enemy);

    protected int getActualPrimaryDamage() {
        return random.nextInt(1, 11);
    }

    protected void hit(Character enemy, int damage) {
        int diff = damage - getActualDefence();
        if (diff > 0) {
            decreaseHitPoint(diff);
        }
    }

    public void primaryAttack(Character enemy) {
        enemy.hit(this, getActualPrimaryDamage());
    }

    public boolean isAlive() {
        return hitPoint > 0;
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Random getRandom() {
        return random;
    }

    private int getActualDefence() {
        return random.nextInt(0, 6);
    }

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }
}
