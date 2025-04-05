package WindowSliding;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = sequence[0]; // 초기값 포함
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;

        while (left <= right && right < sequence.length) {
            if (sum == k) {
                if ((right - left) < minLength) {
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                // 다음 경우를 찾기 위해 왼쪽 이동
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else { // sum > k
                sum -= sequence[left];
                left++;
            }

            // left가 right보다 커졌을 때 처리
            if (left > right && left < sequence.length) {
                right = left;
                sum = sequence[left];
            }
        }

        return answer;
    }
}
