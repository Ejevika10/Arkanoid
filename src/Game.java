import java.io.IOException;

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
        Proxy serialization = new Proxy();
        serialization.deserializeFromTextFile("New.txt",gameField.allObj,settings,players);
    }
    public static void save(){
        Proxy serialization = new Proxy();
        serialization.serializeToJsonFile("Game.json", gameField.allObj.allObj,settings,players);

        try {
            serialization.serializeToTextFile("New.txt", gameField.allObj.allObj, settings,players);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void loadJson() throws InterruptedException, IOException {
        if (gameField == null)
            gameField = new GameField();
        Proxy serialization = new Proxy();
        serialization.deserializeFromJsonFile("Game.json", gameField.allObj, settings,players);
        Game.gameField.menuPanel.updStat();
        switch (Game.settings.size){
            case 1: Game.gameField.chSize(800, 600);
                break;
            case 2: Game.gameField.chSize(900, 700);
                break;
            case 3:Game.gameField.chSize(1150, 800);
                break;
            case 4:Game.gameField.chSize(1300,800);
                break;
            case 5:Game.gameField.chSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
                break;
        }
        resume();
    }

    public static void loadTxt() throws InterruptedException, IOException {
        if (gameField == null)
            gameField = new GameField();
        Proxy serialization = new Proxy();
        serialization.deserializeFromJsonFile("Game.json", gameField.allObj, settings,players);
        //serialization.deserializeFromTextFile("New.txt",gameField.allObj,settings,players);
        switch (Game.settings.size){
            case 1: Game.gameField.chSize(800, 600);
                break;
            case 2: Game.gameField.chSize(900, 700);
                break;
            case 3:Game.gameField.chSize(1150, 800);
                break;
            case 4:Game.gameField.chSize(1300,800);
                break;
            case 5:Game.gameField.chSize((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()-50);
                break;
        }
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