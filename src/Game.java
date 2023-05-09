import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.IOException;
import java.util.TimerTask;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game {
    static GameMenu menu;
    static GameField gameField;
    static Players players;

    public static void main(String[] args) throws InterruptedException {
        start();
    }

    public static void start() throws InterruptedException {
        players = new Players();
        gameField = new GameField();
        menu = new GameMenu();
    }
    public static void exit(){

    }
    public static void save(){
        Serialization serialization = new Serialization();
        //serialization.serializeToTextFile("Game.txt", gameField.allObj.allObj);
        serialization.serializeToJsonFile("Game.json", gameField.allObj.allObj);
    }
    public static void load() throws InterruptedException, IOException {
        if (gameField == null)
            gameField = new GameField();
        Serialization serialization = new Serialization();
        //serialization.deserializeFromTextFile("Game.txt",gameField.allObj);
        serialization.deserializeFromJsonFile("Game.json", gameField.allObj);
        resume();
    }
    public static void pause(){
        gameField.allObj.MyTimer.stop();
        //gameField.setVisible(false);
        menu.showMenu();
    }
    public static void resume(){
        menu.hideMenu();
        //gameField.setVisible(true);
        gameField.setFocusable(true);
        gameField.allObj.MyTimer.start();
    }
}