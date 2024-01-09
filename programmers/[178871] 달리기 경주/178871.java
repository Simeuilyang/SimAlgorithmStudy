import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>(); // <player name, order>
        
        for (int i=0; i<players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for (String calledPlayer : callings) {
            int calledPlayerOrder = playerMap.get(calledPlayer);
            String frontPlayer = players[calledPlayerOrder - 1];
            
            playerMap.put(frontPlayer, calledPlayerOrder);
            playerMap.put(calledPlayer, calledPlayerOrder - 1);
            
            players[calledPlayerOrder] = frontPlayer;
            players[calledPlayerOrder - 1] = calledPlayer;
        }
        
        return players;
    }
}