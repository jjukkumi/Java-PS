import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, ArrayList> cloMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (cloMap.containsKey(clothes[i][1])) {
                ArrayList oldVal = cloMap.get(clothes[i][1]);
                oldVal.add(clothes[i][0]);
                cloMap.put(clothes[i][1], oldVal);

            } else {
                cloMap.put(clothes[i][1], new ArrayList(Arrays.asList(clothes[i][0])));
            }
        }

        int answer = 1;
        Iterator<String> keyIt = cloMap.keySet().iterator();
        while (keyIt.hasNext()) {
            int size = cloMap.get(keyIt.next()).size();
            answer *= (size + 1);
        }
        return answer - 1;
    }
}