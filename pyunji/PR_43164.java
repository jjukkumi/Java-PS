import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution_43164_2 {
    ArrayList<String> paths;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        paths = new ArrayList<>();
        visited = new boolean[tickets.length];
        String[] answer = {};
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(paths);
        return paths.get(0).split(" ");
    }

    public void dfs(String start, String path, String[][] tickets, int count) {
        if(count== tickets.length) {
            paths.add(path);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            if (start.equals(ticket[0]) & !visited[i]) {
                visited[i] = true;
                dfs(ticket[1], path + " " + ticket[1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
}