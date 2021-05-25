import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /* 다리 위를 지나는 중인 트럭들을 나타내는 큐 생성 */
        Queue<Integer> onBridge = new LinkedList<>();
        /* 다리의 길이만큼 0으로 채움 */
        for (int i = 0; i < bridge_length; i++) onBridge.offer(0);

        int seconds = 0;
        int i = 0;
        while (i < truck_weights.length) {
            /* weight: 다리가 견딜 수 있는 여유 무게 */
            /* 새로운 트럭을 진입시키기 전 다리를 빠져나온 트럭의 무게를 여유무게에 더해줌 */
            weight += onBridge.poll();
            /* 다리가 현재 차례의 트럭을 견딜 여유 무게가 되면 */
            if (truck_weights[i] <= weight) {
                /* 현재 차례의 트럭을 진입 시킨 후 다리의 여유무게에서 트럭의 무게를 빼줌 */
                onBridge.offer(truck_weights[i]);
                weight -= truck_weights[i];
                /* 다음 트럭으로 차례를 넘김 */
                i++;
                /* 다리가 현재 차례의 트럭을 진입시킬 수 없으면 */
            } else {
                /* 다리에 0을 넣음: 0은 '무게 0'의 의미와 '시간 1초'의 의미를 가짐 */
                onBridge.offer(0);
            }
            /* 루프를 한 번 돌 때 마다 1초씩 증가함 */
            seconds++;
        }
        /* 마지막 트럭이 다리에 진입하게 되면 while문은 종료됨 */
        /* 마지막 트럭은 다리의 길이만큼의 시간이 지나서 빠져나오므로 전체 소요된 시간에 다리의 길이를 더함 */
        return seconds + bridge_length;
    }
}
