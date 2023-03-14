import java.awt.*;

public class Bonuses {
    Bonus[] bonuses;
    int pos;
    Bonuses(){
    }
    public void addBonus(Bonus bonus)
    {
        bonuses[pos] = bonus;
        pos++;
    }
}
