import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // truck_weight
        Queue<Integer> bridge = new LinkedList<>();
        
        int current_weight = 0;
        for(int truck : truck_weights)
        {
            while(true){
                // if bridge is Empty, Lift the weight of one truck.
                if(bridge.isEmpty()){
                    bridge.offer(truck);
                    answer++;
                    current_weight+=truck;
                    break;
                // When the truck has passed, the size of the queue is equal to the length of the bridge.
                }else if(bridge.size() == bridge_length){
                    current_weight-=bridge.poll();
                // Raise a truck when the bridge is not empty and 
                // the current weight plus the weight of one truck is less than or equal to the maximum load.
                }else if(current_weight + truck <= weight){
                    bridge.offer(truck);
                    answer++;
                    current_weight+=truck;
                    break;
                // 0 is added when the leg is not empty and the weight is exceeded.
                }else{
                    bridge.offer(0);
                    answer++;
                }
            }
        }
        
        return answer + bridge_length;
    }
}