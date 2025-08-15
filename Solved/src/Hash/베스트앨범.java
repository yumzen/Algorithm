package Hash;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // 1. 장르 플레이 수 합산 & 장르 별 고유번호 및 플레이수 정리
        HashMap<String, Integer> genreRank = new HashMap<>();
        HashMap<String, List<int[]>> genreSong = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            genreRank.put(genres[i], genreRank.getOrDefault(genres[i], 0)+plays[i]);
            if(!genreSong.containsKey(genres[i])){
                genreSong.put(genres[i], new ArrayList<>());
            }
            List<int[]> list = genreSong.get(genres[i]);
            list.add(new int[]{i, plays[i]});
        }

        // 2. 장르 순위 구하기
        List<String> sortedGenres = new ArrayList<>(genreRank.keySet());
        sortedGenres.sort((a, b) -> genreRank.get(b) - genreRank.get(a));


        // 3. 장르에서 곡 인기순 정렬
        for(String g: sortedGenres){
            List<int[]> list = genreSong.get(g);
            list.sort((a, b) -> {
                if(b[1] != a[1]) return b[1] - a[1];
                return a[0] - b[0];});
            for(int i = 0; i <list.size() && i<2; i++){
                answer.add(list.get(i)[0]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
