import javax.swing.*;
public class GameField extends JFrame{
    private int x;
    private int y;
    private int x1;
    private int y1;

    AllObjects displayCollection;
    GameField() throws InterruptedException {
        setTitle("My Panel");
        displayCollection = new AllObjects();
        getContentPane().add(displayCollection);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setVisible(true);
        displayCollection.gameCicle();
    }

    public void сheckGameState(){

    }

    public void checkCollision(){}


    public void addPlayer(Player[] players) {

    }
}
