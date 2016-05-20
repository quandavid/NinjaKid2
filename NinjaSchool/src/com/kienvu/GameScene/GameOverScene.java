package com.kienvu.GameScene;

import com.kienvu.Controller.Ninja.NinjaController;
import com.kienvu.GameConfig;
import com.kienvu.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Trà Đá on 5/20/2016.
 */
public class GameOverScene extends GameScene {
    Image backgroundImage;

    public GameOverScene() {
        this.backgroundImage = Utils.loadImage("resources/background/gameover.jpg");


    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.backgroundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
    }

    @Override
    public void run() {

    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ENTER:
                changeScene(SceneType.TUTORIAL);
                break;
        }

    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
