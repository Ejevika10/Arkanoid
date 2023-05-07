import java.awt.*;

public class Blocks {
    public Block[] blocks;
    int pos;
    Blocks(){
        blocks = new Block[27];
        for (int i = 0; i < 9; i++) {
            addBlock(new Block(10+i*110 + 55,10+15,100,30, Color.BLUE.getRed(),Color.BLUE.getGreen(),Color.BLUE.getBlue(),1));
            addBlock(new Block(10+i*110 + 55,50+15,100,30, Color.CYAN.getRed(),Color.CYAN.getGreen(),Color.CYAN.getBlue(),2));
            addBlock(new Block(10+i*110 + 55,90+15,100,30, Color.GREEN.getRed(),Color.GREEN.getGreen(),Color.GREEN.getBlue(),3));
        }
    }
    public void addBlock(Block block)
    {
        blocks[pos] = block;
        pos++;
    }
}
