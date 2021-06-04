import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        /* 요청시점, 소요시간을 기준으로 정렬하는 우선순위 큐를 생성한다. */
        PriorityQueue<int[]> processQ = new PriorityQueue<>(Comparator.comparing((int[] ints) -> ints[0]).thenComparing((int[] ints) -> ints[1]));
        processQ.addAll(Arrays.asList(jobs));

        /* 총 반환시간을 맨 처음 프로세스의 반환 시간으로 초기화한다. */
        int totalReturnTime = processQ.peek()[1];
        
        /* 현재의 시점을 맨 처음 프로세스의 요청 시점과 소요시간을 더해 초기화한다. */
        int[] init = processQ.poll();
        int curTimePointer = init[0] + init[1];

        /* 대기하는 프로세스를 소요시간이 짧은 순으로 정렬하는 우선순위 큐를 생성한다. */
        PriorityQueue<int[]> waitingQ = new PriorityQueue<>(Comparator.comparing((int[] ints) -> ints[1]));

        while (!processQ.isEmpty()) {
            /* 현재의 시점보다 요청 시점이 더 빠른 즉, 대기하고 있는 프로세스를 waitingQ에 넣는다. */
            while (!processQ.isEmpty() && processQ.peek()[0] <= curTimePointer) {
                waitingQ.add(processQ.poll());
            }
            int[] curProcess;
            /* 대기하고 있는 프로세스가 없는 경우 */
            if(waitingQ.isEmpty()){
                /* processQ에서 요청 시점이 가장 빠른 프로세스를 추출한다. */
                curProcess = processQ.poll();
                /* 총 반환 시간에 현재 할당된 프로세스의 소요시간을 더한다. */
                totalReturnTime += curProcess[1];
                /* 현재 시점 curTimePointer를 현재 할당된 프로세스의 "소요시간과 요청 시점을 더한 값"으로 "바꿔"준다. */
                curTimePointer = curProcess[0] + curProcess[1];
            /* 대기하고 있는 프로세스가 존재할 경우 */
            } else {
                /* waitingQ에서 소요 시간이 가장 짧은 프로세스를 추출한다. */
                curProcess = waitingQ.poll();
                /* 총 반환 시간에 현재 프로세스의 반환 시간(대기 시간 + 소요 시간)을 더해준다. */
                totalReturnTime += (curTimePointer - curProcess[0]/* 대기시간 */) + (curProcess[1] /* 소요시간 */);
                /* 현재 시점 curTimePointer를 현재 할당된 프로세스의 "소요시간"을 "더해"준다. */
                curTimePointer += curProcess[1];
                processQ.addAll(waitingQ);
            }
            /* waitingQ를 재사용하기 위해 비워준다. */
            waitingQ.clear();
        }
        return totalReturnTime / jobs.length;
    }
}