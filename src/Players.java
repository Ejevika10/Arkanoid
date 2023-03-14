public class Players {
    Player[] players;

    public String getFullStatistic(){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (Player player:players)
        {
            sb.append(player.getPlayerStatistic());
        }
        String res = sb.toString();
        return res;
    }
    public void addPlayer(){
    }
    public void deletePlayer(){
    }

}
