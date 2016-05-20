package com.kienvu.Controller.EnemyWarriorController;

import com.kienvu.Controller.Colliable.Colliable;
import com.kienvu.Controller.Colliable.ColliablePool;
import com.kienvu.Controller.Ninja.NinjaController;
import com.kienvu.Controller.SingleController;
import com.kienvu.Model.*;
import com.kienvu.Utils;
import com.kienvu.View.AnimationEnemyWarrior.*;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by vukien on 21/05/2016.
 */
public class EnemyWarriorController extends SingleController implements Colliable {
    private EnemyWarriorController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        ColliablePool.getInst().add(this);
        //HPbar hPbar = new HPbar()
    }

    @Override
    public void run() {
        if (gameObject.isALive()) {
            super.run();
//            if (!GameConfig.getInst().isScreen(gameObject.getRectangle())) {
//                gameObject.setALive(false);
//            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (gameObject.isALive()) {
            super.paint(g);
        }

    }

    public static EnemyWarriorController create(int x ,int  y) {
        EnemyWarrior enemyWarrior = new EnemyWarrior(
                x,
                y,
                Utils.loadImage("enemywarrior", "Walk", 10).get(0).getWidth(),
                Utils.loadImage("enemywarrior", "Walk", 10).get(0).getHeight(),
                EnemyWarrior.DEFAULT_HP,
                EnemyWarrior.DEFAULT_DAMAGE
        );

        HPbar hPbar = new HPbar(enemyWarrior.getX(), enemyWarrior.getY() - 5, 80, 10);
        enemyWarrior.sethPbar(hPbar);

        //WALK
        LeftEnemyDrawer leftEnemyDrawer = new LeftEnemyDrawer(Utils.loadImage("enemywarrior", "Walk", 10));

        //ATTACK
        AttackEnemyDrawer attackEnemyDrawer = new AttackEnemyDrawer(Utils.loadImage("enemywarrior", "Attack", 10));

        //DYING
        DyingEnemyDrawer dyingEnemyDrawer = new DyingEnemyDrawer(Utils.loadImage("enemywarrior", "Dead", 10));

        //EnemyDrawer
        EnemyDrawer enemyDrawer = new EnemyDrawer( attackEnemyDrawer, dyingEnemyDrawer, leftEnemyDrawer);

        //EnemyHPDrawer
        EnemyHPDrawer enemyHPDrawer = new EnemyHPDrawer(Utils.loadHPBarImages_1());

        //EnemyComboDrawer
        EnemyComboDrawer enemyComboDrawer = new EnemyComboDrawer(enemyDrawer, enemyHPDrawer);

        GameVector gameVector = new GameVector(-EnemyWarrior.DEFAULT_SPEED, 0);

        EnemyWarriorController enemyWarriorController = new EnemyWarriorController(
                enemyWarrior,
                enemyComboDrawer,
                gameVector
        );
        return enemyWarriorController;
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof NinjaController) {
            Ninja ninja = (Ninja) c.getGameObject();
            if(ninja.getLifeState() == LifeState.ATTACK_LEFT || ninja.getLifeState() == LifeState.ATTACK_RIGHT) {
                ((GameObjectWithHP)gameObject).descrease(10);
                if (((GameObjectWithHP)gameObject).getHp() <= 0) {
                    ((GameObjectWithHP)gameObject).setLifeState(LifeState.DYING_LEFT);
                }
            }
        }
    }
}
