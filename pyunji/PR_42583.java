import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> onBridge = new LinkedList();
        for (int i = 0; i < bridge_length; i++) onBridge.offer(0);
        int i=0;
        
        while(i<truck_weights.length) {
            weight += onBridge.poll();
                if(truck_weights[i]<=weight){
                    onBridge.offer(truck_weights[i]);
                    weight -= truck_weights[i];
                    i++;
                } else {
                    onBridge.offer(0);
                }
                answer++;
        }
        return answer+bridge_length;
    }
}