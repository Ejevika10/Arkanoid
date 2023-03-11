public class MenuItem extends Element{

    String someInfo;


    public MenuItem(int color, int x, int y, int width, int height, int type, String someInfo) {
        super(color, x, y, width, height, type);
        this.someInfo = someInfo;
    }

    @Override
    void move() {

    }

    void onClick(){

    }
}
