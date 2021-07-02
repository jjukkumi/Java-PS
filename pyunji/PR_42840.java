import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1Rule = {1,2,3,4,5};
        int[] supo2Rule = {2,1,2,3,2,4,2,5};
        int[] supo3Rule = {3,3,1,1,2,2,4,4,5,5};
        int[][] supoRules = {supo1Rule, supo2Rule, supo3Rule};
        
        int[] supoScores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for (int j = 0; j < supoRules.length; j++) {
                if(supoRules[j][i%supoRules[j].length]==answers[i]) supoScores[j]++;
            }
        }
        int maxScore = 0;
        for(int score: supoScores) if(score>maxScore) maxScore = score;

        ArrayList<Integer> supos = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if (supoScores[i]==maxScore) supos.add(i+1);
        }

        int[] answerArr = new int[supos.size()];
        int count = 0;
        for(int supo: supos) answerArr[count++] = supo;
        
        return answerArr;
    }
}