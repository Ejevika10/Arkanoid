import java.awt.*;

public class Blocks {
    public Block[] blocks;
    int pos;
    Blocks(){
        int x=10,y=10;
        blocks = new Block[21];
        for (int i = 0; i < 7; i++) {
            addBlock(new Block(10+i*60,10,10+i*60+ 50,10 + 20,50,20, Color.BLUE,2,false,1));
            addBlock(new Block(10+i*60,40,10+i*60+ 50,40 + 20,50,20, Color.CYAN,2,false,2));
            addBlock(new Block(10+i*60,70,10+i*60+ 50,70 + 20,50,20, Color.GREEN,2,false,3));
        }
    }
    public void addBlock(Block block)
    {
        blocks[pos] = block;
        pos++;
    }
}
