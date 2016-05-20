package com.kienvu.View.AnimationEnemyWarrior;

import com.kienvu.Model.GameObject;
import com.kienvu.View.GameDrawer;

import java.awt.*;

/**
 * Created by vukien on 21/05/2016.
 */
public class EnemyComboDrawer extends GameDrawer {
    private EnemyDrawer enemyDrawer;
    private EnemyHPDrawer enemyHPDrawer;

    public EnemyComboDrawer(EnemyDrawer enemyDrawer, EnemyHPDrawer enemyHPDrawer) {
        this.enemyDrawer = enemyDrawer;
        this.enemyHPDrawer = enemyHPDrawer;
    }
    @Override
    public void paint(Graphics g, GameObject gameObject) {
        enemyDrawer.paint(g, gameObject);
        enemyHPDrawer.paint(g, gameObject);
    }
}
