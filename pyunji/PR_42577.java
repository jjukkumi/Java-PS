import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        Map<Character, ArrayList<String>> preMap = new HashMap<>();

        for (String num : phone_book) {
            char key = num.charAt(0);
            ArrayList<String> tmpVal = preMap.getOrDefault(key, new ArrayList<>());
            tmpVal.add(num);
            preMap.put(key, tmpVal);
        }
        for(char key:preMap.keySet()){
            ArrayList<String> valList = preMap.get(key);
            for(int i = 0; i< valList.size()-1; i++) {
                if(valList.get(i + 1).startsWith(valList.get(i)))
                    return false;
            }
        }

        return true;
    }
}
