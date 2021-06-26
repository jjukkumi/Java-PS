import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    boolean[] marked;
    ArrayList<Integer> answers;

    public int solution(String begin, String target, String[] words) {
        marked = new boolean[words.length];
        List<String> wordList = Arrays.asList(words);
        if (!wordList.contains(target)) return 0;
        answers = new ArrayList<>();

        dfs(begin, target, words, 0);


        answers.sort(Comparator.naturalOrder());
        return answers.get(0);
    }

    private void dfs(String begin, String target, String[] words, int count) {
        if (canConvert(begin, target)) {
            answers.add(count + 1);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (!marked[i] & canConvert(begin, words[i])) {
                marked[i] = true;
                dfs(words[i], target, words, count + 1);
                marked[i] = false;
            }
        }
    }

    public boolean canConvert(String begin, String next) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == next.charAt(i)) count++;
        }
        return count + 1 == begin.length();
    }
}