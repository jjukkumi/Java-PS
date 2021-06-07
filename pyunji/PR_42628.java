import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        String DELETE_MAX = "D 1";
        String DELETE_MIN = "D -1";

        /* 정렬방식이 서로 반대인 큐를 생성한다 */
        PriorityQueue<Integer> priQ = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> reversePriQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            if (operation.equals(DELETE_MAX)) {
                reversePriQ.poll();
                priQ.clear();
                priQ.addAll(reversePriQ);
            } else if (operation.equals(DELETE_MIN)) {
                priQ.poll();
                reversePriQ.clear();
                reversePriQ.addAll(priQ);
            } else {
                int elem = Integer.parseInt(operation.substring(2));
                priQ.add(elem);
                reversePriQ.add(elem);
            }
        }
        if (priQ.isEmpty()) return new int[]{0, 0};
        else return new int[]{reversePriQ.poll(), priQ.poll()};
    }
}