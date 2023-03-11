public class GameMessage extends Element{
    private String info;

    public GameMessage(String color, int x, int y, int width, int height, int type,String info) {
        super(color, x, y, width, height, type);
        this.info = info;
    }


    public void setMessage(String message) {
        this.info = message;
    }

    public void show(){

    }
    public void hide(){

    }

    @Override
    void move() {

    }


}
