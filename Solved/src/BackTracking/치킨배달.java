package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {
    // 선택된 치킨집(picked) 기준으로 도시 치킨 거리 합 계산
    // 부분합이 이미 best 이상이면 조기 종료(가지치기)
    static int calculateDistance(int[][] dist, boolean[] picked, int best) {
        int H = dist.length;        // 집 개수
        int K = picked.length;      // 치킨집 개수
        int sum = 0;

        for (int h = 0; h < H; h++) {
            int minD = Integer.MAX_VALUE;
            for (int k = 0; k < K; k++) {
                if (picked[k]) {
                    int d = dist[h][k];
                    if (d < minD) minD = d;
                    if (minD == 0) break; // 더 줄일 수 없음
                }
            }
            sum += minD;
            if (sum >= best) return sum; // 가지치기
        }
        return sum;
    }

    // shops 중에서 M개 선택: idx = 현재 보고 있는 치킨집 인덱스, cnt = 지금까지 고른 수
    static int backtracking(boolean[] picked, int[][] dist, int idx, int cnt, int M, int best) {
        int K = picked.length;

        // M개 선택 완료 → 도시 치킨 거리 계산
        if (cnt == M) {
            int city = calculateDistance(dist, picked, best);
            return Math.min(best, city);
        }
        // 끝까지 봤으면 종료
        if (idx == K) return best;

        // 가지치기: 남은 걸 전부 골라도 M개 못 채우면 종료
        if (cnt + (K - idx) < M) return best;

        // 1) idx 치킨집 선택
        picked[idx] = true;
        best = backtracking(picked, dist, idx + 1, cnt + 1, M, best);

        // 2) idx 치킨집 미선택
        picked[idx] = false;
        best = backtracking(picked, dist, idx + 1, cnt, M, best);

        return best;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> houses = new ArrayList<>();
        List<int[]> shops  = new ArrayList<>();

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) houses.add(new int[]{r, c});
                else if (v == 2) shops.add(new int[]{r, c});
            }
        }

        int H = houses.size();
        int K = shops.size();
        boolean[] picked = new boolean[K];

        // 집-치킨집 거리 미리 계산
        int[][] dist = new int[H][K];
        for (int h = 0; h < H; h++) {
            int hr = houses.get(h)[0], hc = houses.get(h)[1];
            for (int k = 0; k < K; k++) {
                int sr = shops.get(k)[0], sc = shops.get(k)[1];
                dist[h][k] = Math.abs(hr - sr) + Math.abs(hc - sc);
            }
        }

        int best = backtracking(picked, dist, 0, 0, M, Integer.MAX_VALUE);
        System.out.println(best);
    }
}