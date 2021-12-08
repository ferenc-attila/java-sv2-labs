package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private static final int MAX_DAMAGE = 10;
    private static final int MAX_DEFENSE = 5;

    private Point position;
    private int hitPoint;
    private Random random;

    public Character(Point position, Random random) {
        this.position = position;
        this.random = random;
        this.hitPoint = 100;
    }

    public abstract void secondaryAttack(Character enemy);

    protected int getActualPrimaryDamage() {
        return random.nextInt(1, MAX_DAMAGE + 1);
    }

    protected void hit(Character enemy, int damage) {
        if (damage > enemy.getActualDefence()) {
            enemy.decreaseHitPoint(damage);
        }
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
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
        return random.nextInt(0, MAX_DAMAGE + 1);
    }

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }
}
