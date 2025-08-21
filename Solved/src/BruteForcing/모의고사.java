package BruteForcing;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] score = {0,0,0};
        ArrayList<Integer> answer = new ArrayList<>();
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i = 0; i < answers.length; i++){
            // 수포자 1
            if(answers[i] == student1[i%student1.length]) score[0]++;
            if(answers[i] == student2[i%student2.length]) score[1]++;
            if(answers[i] == student3[i%student3.length]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for (int i = 0; i < 3; i++) {
            if (score[i] == max) answer.add(i+1);
        }

        int[] list = new int[answer.size()];
        for(int i =0; i<answer.size(); i++){
            list[i] = answer.get(i);
        }
        return list;
    }
}
