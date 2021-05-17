import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer> duplicatedCloth = new HashMap<String,Integer>();
        
        for(String[] cloth: clothes){
            List<String> c = Arrays.asList(cloth);
            if(duplicatedCloth.keySet().contains(c.get(1))){
                duplicatedCloth.put(c.get(1),duplicatedCloth.get(c.get(1))+1);
            }else{
                duplicatedCloth.put(c.get(1),1);
            }
        }
        if(duplicatedCloth.values().size() == 1)return clothes.length;
        
        return duplicatedCloth.values().stream().mapToInt(a -> a).sum() + 
            duplicatedCloth.values().stream().reduce(1, (a, b) -> a * (b+1) - 1);
    }
}