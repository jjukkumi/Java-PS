import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        reverseNumber(citations);

        for(int i=0; i<citations.length; i++){
            if(citations[i]<= i){
                return i;
            }
        }
        
        return answer;
    }
    
    public static void reverseNumber(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}