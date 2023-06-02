import java.awt.*;
import java.util.ArrayList;

public class Blocks {
    public ArrayList<Block> blocks;
    int pos;
    Blocks(int width){
        int blWidth = (width - 135)/9 - 10;
        blocks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            addBlock(new Block(5+i*(blWidth + 10) + blWidth/2,10+15,blWidth,30, Color.BLUE.getRed(),Color.BLUE.getGreen(),Color.BLUE.getBlue(),3));
            addBlock(new Block(5+i*(blWidth + 10) + blWidth/2,50+15,blWidth,30, Color.CYAN.getRed(),Color.CYAN.getGreen(),Color.CYAN.getBlue(),2));
            addBlock(new Block(5+i*(blWidth + 10) + blWidth/2,90+15,blWidth,30, Color.GREEN.getRed(),Color.GREEN.getGreen(),Color.GREEN.getBlue(),1));
        }
        blocks.get(0).hardness = 1000;
        blocks.get(0).colorR = Color.YELLOW.getRed();
        blocks.get(0).colorG = Color.YELLOW.getGreen();
        blocks.get(0).colorB = Color.YELLOW.getBlue();

        blocks.get(2).hardness = 1000;
        blocks.get(2).colorR = Color.YELLOW.getRed();
        blocks.get(2).colorG = Color.YELLOW.getGreen();
        blocks.get(2).colorB = Color.YELLOW.getBlue();

        blocks.get(24).hardness = 1000;
        blocks.get(24).colorR = Color.YELLOW.getRed();
        blocks.get(24).colorG = Color.YELLOW.getGreen();
        blocks.get(24).colorB = Color.YELLOW.getBlue();

        blocks.get(26).hardness = 1000;
        blocks.get(26).colorR = Color.YELLOW.getRed();
        blocks.get(26).colorG = Color.YELLOW.getGreen();
        blocks.get(26).colorB = Color.YELLOW.getBlue();
    }
    public void addBlock(Block block)
    {
        blocks.add(block);
    }
    public void chSize(int width){
        int blWidth = (width - 135)/9 - 10;
        for (int i = 0; i < 9; i+=3) {
            blocks.get(i).chSize(5+i*(blWidth + 10) + blWidth/2, blWidth);
            blocks.get(i + 1).chSize(5+i*(blWidth + 10) + blWidth/2, blWidth);
            blocks.get(i + 2).chSize(5+i*(blWidth + 10) + blWidth/2, blWidth);
        }
    }
}
