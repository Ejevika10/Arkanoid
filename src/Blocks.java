import java.awt.*;

public class Blocks {
    public Block[] blocks;
    int pos;
    Blocks(){
        blocks = new Block[27];
        for (int i = 0; i < 9; i++) {
            addBlock(new Block(10+i*110 + 55,10+15,100,30, Color.BLUE,1));
            addBlock(new Block(10+i*110 + 55,50+15,100,30, Color.CYAN,2));
            addBlock(new Block(10+i*110 + 55,90+15,100,30, Color.GREEN,3));
        }
    }
    public void addBlock(Block block)
    {
        blocks[pos] = block;
        pos++;
    }
}
