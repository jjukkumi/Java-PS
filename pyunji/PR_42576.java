import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] public String solution(String[] participant, String[] completion) {
            Map<String, Integer> parMap =new HashMap<>();
            for(String par : participant) parMap.put(par, parMap.getOrDefault(par, 0) + 1);
            for(String comp: completion) parMap.put(comp, parMap.get(comp) - 1);

        return parMap.entrySet().stream().filter(entry -> entry.getValue() != 0).findFirst().map(Map.Entry::getKey).orElse("");
    }
}
