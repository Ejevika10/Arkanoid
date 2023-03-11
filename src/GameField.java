public class GameField {
    private int x;
    private int y;
    private int x1;
    private int y1;

    private Block[] blocks;
    private Player[] players;

    public GameField(int x,int y, int x1,int y1, Block[] blocks, Player[] players )
    {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.blocks=blocks;
        this.players=players;
    }

    public void сheckGameState(){

    }

    public void checkCollision(){}


    public void addPlayer(Player[] players) {

    }
}
