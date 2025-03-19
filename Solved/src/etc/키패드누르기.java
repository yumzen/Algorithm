package etc;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String[][] keypad = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {"*", "0", "#"}
        };
        String answer = "";
        Integer[] left = {3, 0};
        Integer[] right = {3, 2};
        for(int i = 0 ; i < numbers.length ; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                left = new Integer[]{numbers[i] / 3, 0};
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                right = new Integer[]{numbers[i] / 3 - 1, 2};
            } else {
                int number_x = numbers[i] == 0 ? 3 : numbers[i] / 3;
                int number_y = 1;
                int left_x = left[0];
                int left_y = left[1];
                int right_x = right[0];
                int right_y = right[1];
                int left_distance = Math.abs(number_x - left_x) + Math.abs(number_y - left_y);
                int right_distance = Math.abs(number_x - right_x) + Math.abs(number_y - right_y);
                if(left_distance < right_distance){
                    answer += "L";
                    left = new Integer[]{number_x, number_y};
                } else if(left_distance > right_distance){
                    answer += "R";
                    right = new Integer[]{number_x, number_y};
                } else {
                    if(hand.equals("left")){
                        answer += "L";
                        left = new Integer[]{number_x, number_y};
                    } else {
                        answer += "R";
                        right = new Integer[]{number_x, number_y};
                    }
                }
            }
        }

        return answer;
    }
}
