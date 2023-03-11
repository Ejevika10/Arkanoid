public class Bonus extends Element{
    int bonusType;

    public Bonus(int color, int x, int y, int width, int height, int type,int bonusType) {
        super(color, x, y, width, height, type);
        this.bonusType = bonusType;
    }

    @Override
    void move() {

    }
}
