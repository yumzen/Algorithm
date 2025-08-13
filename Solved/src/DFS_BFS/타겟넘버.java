package DFS_BFS;

public class 타겟넘버 {
    static int answer = 0;
    public static void dfs(int[]numbers, int target, int index, int value){
        if(index == numbers.length){
            if(value == target) answer++;
            return;
        }
        dfs(numbers, target, index+1, value+numbers[index]);
        dfs(numbers, target, index+1, value-numbers[index]);
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}
