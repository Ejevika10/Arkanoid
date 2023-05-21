import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.IOException;
import java.util.TimerTask;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Game {
    static Settings settings;
    static GameMenu menu;
    static GameField gameField;
    static Players players;
    static GameMessage gameMsg;
    public static void main(String[] args) throws InterruptedException {
        settings = new Settings();
        start();
    }

    public static void start() throws InterruptedException {
        menu = new GameMenu();
        gameField = new GameField();
        players = new Players();
        //gameField.add(menu);
    }
    public static void exit(){

    }
    public static void save(){
        Serialization serialization = new Serialization();
        serialization.serializeToTextFile("Game.txt", gameField.allObj.allObj, settings,players);
        serialization.serializeToJsonFile("Game.json", gameField.allObj.allObj,settings,players);
    }
    public static void loadJson() throws InterruptedException, IOException {
        if (gameField == null)
            gameField = new GameField();
        Serialization serialization = new Serialization();
        serialization.deserializeFromJsonFile("Game.json", gameField.allObj, settings,players);
        resume();
    }

    public static void loadTxt() throws InterruptedException, IOException {
        if (gameField == null)
            gameField = new GameField();
        Serialization serialization = new Serialization();
        serialization.deserializeFromTextFile("Game.txt",gameField.allObj,settings,players);
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
    public static void gameOver(){
        gameField.allObj.MyTimer.stop();
        gameMsg = new GameMessage("Game over");
        gameMsg.showMsg();

    }
}