import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int[] solution(int[] answers) {
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] stus = {stu1, stu2, stu3};
        int[] stus_score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < stus.length; j++) {
                if (answers[i] == stus[j][i % stus[j].length]) {
                    stus_score[j]++;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        OptionalInt MAX = Arrays.stream(stus_score).max();
        for (int i = 0; i < 3; i++) {
            if (MAX.getAsInt()==stus_score[i]) {
                answer.add(i+1);
            }

        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}