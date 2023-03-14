public class Game {

    private static GameField gameField;


    public static void main(String[] args) throws InterruptedException {
        start();
    }

    public static void initField(GameField field){

    }
    public static void start() throws InterruptedException {
        gameField = new GameField();
    }

}