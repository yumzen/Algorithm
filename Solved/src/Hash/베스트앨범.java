package Hash;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르를 담은 해시 맵 생성
        Map<String, Integer> genresMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            // genresMap에 장르의 플레이횟수를 담기
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 2. 장르별 총 재생 횟수를 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genresMap.keySet());
        sortedGenres.sort((a, b) -> genresMap.get(b) - genresMap.get(a));

        //장르 안에서, 가장 많이 재생된 노래의 고유 번호부터 sort해서 넣기 이떄, 재생수가 같으면 index 오름차순으로
        List<Integer> answerList = new ArrayList<>();
        int answerIndex = 0;
        for(String genre: sortedGenres){
            // 장르의 play 인덱스를 저장하는 과정
            List<Integer> genrePlaysIndex = new ArrayList<>();
            for(int i = 0; i < plays.length; i++){
                //해당 장르라면,
                if(genre.equals(genres[i])){
                    genrePlaysIndex.add(i);
                }
            }

            // 이제, genrePlaysIndex를 플레이횟수의 내림차순으로 정렬한다.
            genrePlaysIndex.sort((a,b) -> plays[b] - plays[a]);

            // 2개만 사용
            for(int i = 0 ; i < genrePlaysIndex.size() && i < 2; i ++){
                answerList.add(genrePlaysIndex.get(i));
            }
        }
        // List -> int[] 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
