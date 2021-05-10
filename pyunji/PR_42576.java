import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map <String, Integer> parMap = new HashMap();
        String answer = "";
        for (String person: participant) {
            parMap.put(person, 0);
        }

        for (String person: participant) {
            if (parMap.containsKey(person)) {
                int value = parMap.get(person);
                parMap.put(person, value + 1);
            }
        }

        for (String person: completion) {
            int value = parMap.get(person);
            parMap.put(person, value - 1);
        }
        for (String person : participant) {
            if (parMap.get(person).equals(1)) {
                answer = person;
                break;
            }
        }
        return answer;
    }
}