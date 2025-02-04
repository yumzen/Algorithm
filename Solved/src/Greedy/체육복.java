package Greedy;

public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int[] students = new int[n];
        int answer = n;

        // 체육복을 잃어버린 학생은 -1, 여분의 체육복이 있는 학생은 +1
        for(int l: lost){
            students[l - 1]--;
        }
        for(int r: reserve){
            students[r - 1]++;
        }

        // 체육복을 빌려줄 수 있는 학생이면 빌려주고, 빌려준 학생은 -1, 빌려받은 학생은 +1
        for(int i = 0; i < n; i++){
            if(students[i] == -1){
                if(i - 1 >= 0 && students[i - 1] == 1){
                    students[i]++;
                    students[i - 1]--;
                } else if(i + 1 < n && students[i + 1] == 1){
                    students[i]++;
                    students[i + 1]--;
                } else {
                    answer--;
                }
            }
        }
        System.out.println(answer);
    }
}
