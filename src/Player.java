public class Player {
    PlayerStatistic stat;
    Platform platform;
    Balls balls;

    public String getPlayerStatistic(){
        StringBuilder sb = new StringBuilder();
        sb.append(stat.name);
        sb.append(Integer.toString(stat.score));
        sb.append(Integer.toString(stat.lives));
        String res = sb.toString();
        return res;
    }
}
