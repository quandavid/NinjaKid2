package com.kienvu.Model;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class EnemyWarrior extends GameObjectWithHP {
    public static int DEFAULT_SPEED = 2;
    public static int DEFAULT_DAMAGE = 10;
    public static int DEFAULT_HP = 100;
    private HPbar hPbar;
    public EnemyWarrior(int x, int y, int width, int height, int hp, int damage) {
        super(x, y, width, height, hp, damage);
        this.setLifeState(LifeState.RUN_LEFT);
    }

    public HPbar gethPbar() {
        return this.hPbar;
    }

    public void sethPbar(HPbar hPbar) {
        this.hPbar = hPbar;
    }

    @Override
    public void move(GameVector gameVector) {
        super.move(gameVector);
        hPbar.setX(getX());
        hPbar.setY(getY());
    }
}
