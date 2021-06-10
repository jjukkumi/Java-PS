import java.util.*;


class Solution {
    public int[] solution(int[] answers) {
        Student[] students = {
                new Student(1, new int[]{1, 2, 3, 4, 5}),
                new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
                new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}),

        };

        for (int i = 0; i < answers.length; i++) {
            for (Student student : students) {
                if (answers[i] == student.getAnswer(i)) student.scoreUp();
            }
        }
        
        int maxScore = 0;
        for (Student student : students) {
            if(maxScore < student.getScore()) maxScore = student.getScore();
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (Student student : students) {
            if(maxScore==student.getScore()) answer.add(student.getId());
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class Student {
    int id;
    int[] answerList;
    int score;

    public Student(int id, int[] answerList) {
        this.id = id;
        this.answerList = answerList;
    }

    public int getId() {
        return id;
    }

    public int getAnswerLength() {
        return answerList.length;
    }

    public void scoreUp() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public int getAnswer(int i) {
        return answerList[i % getAnswerLength()];
    }
}