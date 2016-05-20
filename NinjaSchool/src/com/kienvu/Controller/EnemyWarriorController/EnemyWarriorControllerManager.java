package com.kienvu.Controller.EnemyWarriorController;

import com.kienvu.Controller.ControllerManager;
import com.kienvu.GameConfig;
import com.kienvu.Model.EnemyWarrior;


/**
 * Created by vukien on 21/05/2016.
 */
public class EnemyWarriorControllerManager extends ControllerManager {
    private int count = 0;

    private EnemyWarriorControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        if (GameConfig.getInst().durationInSeconds(count) > 2) {
            count = 0;
            this.add(EnemyWarriorController.create(1000, 400));
        }
    }

    private static EnemyWarriorControllerManager inst;
    public static EnemyWarriorControllerManager getInst() {
        if (inst == null) {
            inst = new EnemyWarriorControllerManager();
        }
        return inst;
    }

    public static void setNULL() {
        inst = null;
    }
}
