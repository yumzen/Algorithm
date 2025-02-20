package etc;

public class 택배상자꺼내기 {
    public static void main(String[] args) {
        int n = 22; // 전체 상자 수
        int w = 6;  // 한 줄에 놓을 수 있는 상자 수
        int num = 8; // 꺼낼 상자 번호

        // 몇 번째 층에 위치하는지
        int layer = (num - 1) / w;

        // 몇 번째 열(column)에 위치하는지 찾기
        int indexInLayer = (num - 1) % w; // 0-based index

        // 열(column) 찾기 (층이 짝수면 왼 -> 오, 홀수면 오 -> 왼)
        int column;
        if (layer % 2 == 0) {
            column = indexInLayer; // 짝수 층: 왼 -> 오
        } else {
            column = w - 1 - indexInLayer; // 홀수 층: 오 -> 왼
        }

        // 위에 있는 상자 개수 계산
        int count = 0;
        for (int i = layer; i < (n + w - 1) / w; i++) {
            if (i % 2 == 0) { // 짝수층: 왼 -> 오
                if (column < (n - i * w)) count++;
            } else { // 홀수층: 오 -> 왼
                if ((w - 1 - column) < (n - i * w)) count++;
            }
        }

        System.out.println(count);
    }
}