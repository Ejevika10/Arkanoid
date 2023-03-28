import javax.swing.*;
public class GameField extends JFrame{
    private int x;
    private int y;
    private int x1;
    private int y1;

    AllObjects allObj;
    GameField() throws InterruptedException {
        setTitle("Arkanoid");
        allObj = new AllObjects();
        getContentPane().add(allObj);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setVisible(true);
        allObj.gameCicle();
    }

    public void сheckGameState(){

    }
}
