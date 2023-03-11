public class Block extends Element {
    private int hardness;
    Bonus bonus;

    public Block(int color, int x, int y, int width, int height, int type,int hardness) {
        super(color, x, y,width,height, type);
        this.hardness = hardness;
    }
    public void setHardness(int hardness){
        this.hardness = hardness;
    }

    public int getHardness(){
        return this.hardness;
    }
    public void destroy(){

    }
    public void getBonus(Bonus bonus){

    }

    @Override
    void move() {

    }
}
