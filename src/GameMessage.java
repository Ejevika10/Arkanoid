public class GameMessage extends Element{
    private String message;

    public GameMessage(String message, String color, int x, int y) {
        super(color, x, y);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    void showMessage(){

    }

    @Override
    void move() {

    }


}
