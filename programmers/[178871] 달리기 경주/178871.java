import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> playerMap = new HashMap<>(); // <player name, order>
        Map<Integer, String> orderMap = new HashMap<>(); // <order, player>
        
        for (int i=0; i<players.length; i++) {
            playerMap.put(players[i], i);
            orderMap.put(i, players[i]);
        }
        
        for (String calledPlayer : callings) {
            int calledPlayerOrder = playerMap.get(calledPlayer);
            String frontPlayer = orderMap.get(calledPlayerOrder - 1);
            
            playerMap.put(frontPlayer, calledPlayerOrder);
            playerMap.put(calledPlayer, calledPlayerOrder - 1);
            
            orderMap.put(calledPlayerOrder, frontPlayer);
            orderMap.put(calledPlayerOrder - 1, calledPlayer);
        }
        
        for (int i=0; i<players.length; i++) {
            answer[i] = orderMap.get(i);
        }
        
        return answer;
    }
}