import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        HashMap<Integer,Integer> sortedPriorities = new HashMap<>();
        
        for(int i=0; i<priorities.length; i++){
            sortedPriorities.put(i,priorities[i]);
        }
        
        int k = getKey(sortedPriorities,Collections.max(sortedPriorities.values()));
        
        if(k < location){
            answer = (k - location) + 1; 
        }else if(k == location){
            answer = 1;
        }else{
            answer = k + (k - location) + 1;
        }
        return answer;
    }
    
    public static <K,V> K getKey(Map<K,V> map, V value){
        
        for(K key : map.keySet()){
            if (value.equals(map.get(key))){
                return key;
            }
        }
        return null;
    }
}