import java.awt.*;

public class Blocks {
    public Block[] blocks;
    int pos;
    Blocks(int width){
        int blWidth = (width - 135)/9 - 10;
        blocks = new Block[27];
        for (int i = 0; i < 9; i++) {
            addBlock(new Block(5+i*(blWidth + 10) + blWidth/2,10+15,blWidth,30, Color.BLUE.getRed(),Color.BLUE.getGreen(),Color.BLUE.getBlue(),1));
            addBlock(new Block(5+i*(blWidth + 10) + blWidth/2,50+15,blWidth,30, Color.CYAN.getRed(),Color.CYAN.getGreen(),Color.CYAN.getBlue(),2));
            addBlock(new Block(5+i*(blWidth + 10) + blWidth/2,90+15,blWidth,30, Color.GREEN.getRed(),Color.GREEN.getGreen(),Color.GREEN.getBlue(),3));
        }
    }
    public void addBlock(Block block)
    {
        blocks[pos] = block;
        pos++;
    }
    public void chSize(int width){
        int blWidth = (width - 135)/9 - 10;
        for (int i = 0; i < 9; i+=3) {
            blocks[i].chSize(5+i*(blWidth + 10) + blWidth/2, blWidth);
            blocks[i + 1].chSize(5+i*(blWidth + 10) + blWidth/2, blWidth);
            blocks[i + 2].chSize(5+i*(blWidth + 10) + blWidth/2, blWidth);
        }
    }
}
