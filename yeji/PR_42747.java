import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        
        List<Integer> citationList = Arrays.stream(citations).boxed().collect(Collectors.toList());
        
        Collections.sort(citationList, Collections.reverseOrder());

        for(int i=0; i<citationList.size(); i++){
            if(citationList.get(i) <= i){
                return i;
            }
                
        }
        
        return answer;
    }
}