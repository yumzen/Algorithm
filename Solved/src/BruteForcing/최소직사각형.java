package BruteForcing;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int x = Math.max(sizes[0][0], sizes[0][1]);
        int y = Math.min(sizes[0][0], sizes[0][1]);

        for(int i = 1; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            x = Math.max(x, max);
            y = Math.max(y, min);
        }
        System.out.println(x * y);
    }
}
