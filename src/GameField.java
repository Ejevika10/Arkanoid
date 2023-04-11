import javax.swing.*;
public class GameField extends JFrame{
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 1015;
    private int y2 = 800;

    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }

    AllObjects allObj;
    GameField() throws InterruptedException {
        setTitle("Arkanoid");
        allObj = new AllObjects();
        getContentPane().add(allObj);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(x2-x1, y2-y1);
        setVisible(true);
        allObj.gameCicle();
    }

    public void сheckGameState(){

    }
}
