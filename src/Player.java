public class Player {
    public int score;
    public int lives;
    public String name;

    public String getPlayerStatistic(){
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(Integer.toString(score));
        sb.append(Integer.toString(lives));
        String res = sb.toString();
        return res;
    }
}
