public class GameField {
    private int height;
    private int width;

    private Block[] blocks;
    private Player[] players;

    public GameField(int width, int height, Block[] blocks, Player[] players )
    {
        this.width=width;
        this.height=height;
        this.blocks=blocks;
        this.players=players;
    }

    void CheckGameState(){

    }
}
