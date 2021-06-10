import java.util.*;
import java.util.stream.*;

class PR_42747 {
    public int solution(int[] citations) {
        int answer = 0;
        
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