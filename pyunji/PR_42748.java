import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i = 0;
        for (int[] command : commands) {
            answer[i] = Arrays.stream(array)
                    .limit(command[1])
                    .skip(command[0]-1)
                    .sorted()
                    .toArray()[command[2]-1];
            i++;
        }
        return answer;
    }
}