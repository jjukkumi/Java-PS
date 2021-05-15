import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String,String> map1 = new HashMap<String,String>();
        
        for(int i =0; i<record.length; i++){
            String[] eachRecord = record[i].split(" ");
            if(eachRecord[0].equals("Enter")){
                map1.put(eachRecord[1],eachRecord[2]+"님이 들어왔습니다.");
            } else if(eachRecord.equals("Leave")){
                map1.put(eachRecord[1],eachRecord[2]+"님이 나갔습니다.");
            } else if(eachRecord.equals("Change")){
                map1.put(eachRecord[1],eachRecord[2]+"님이 나갔습니다.");
            }
        }
        System.out.println(map1);
        return answer;
    }
}