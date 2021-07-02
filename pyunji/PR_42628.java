import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> orderedQ = new PriorityQueue<>();
        PriorityQueue<Integer> revOrdQ = new PriorityQueue<>(Comparator.reverseOrder());
        
        String DELETE_MAX = "D 1";
        String DELETE_MIN = "D -1";
        for(String operation: operations) {
            if(operation.equals(DELETE_MAX)) {
                orderedQ.remove(revOrdQ.poll());
            } else if (operation.equals(DELETE_MIN)) {
                revOrdQ.remove(orderedQ.poll());
            } else {
                int input = Integer.parseInt(operation.split(" ")[1]);
                orderedQ.offer(input);
                revOrdQ.offer(input);
            }
        }
        if (orderedQ.isEmpty()) return new int[] {0,0};
        return new int[] {revOrdQ.poll(), orderedQ.poll()};
    }
}