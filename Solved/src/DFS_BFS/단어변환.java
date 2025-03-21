package DFS_BFS;

public class 단어변환 {
    public boolean isOneCharDiff(String a, String b){
        int diff = 0;
        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
    public int dfs(String begin, String target, String[] words, int step, boolean[] visited, int min){
        if(begin.equals(target)) return step;
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(!visited[i] && isOneCharDiff(begin, word)){
                visited[i] = true;
                int result = dfs(word, target, words, step+1, visited, min);
                if( result > 0){
                    min = Math.min(min, result);
                }
                visited[i] = false;
            }
        }
        return min == words.length+1 ? 0 : min;
    }
    public boolean isContain(String target, String[] words){
        for(String word: words){
            if(word.equals(target)) return true;
        }
        return false;
    }
    public int solution(String begin, String target, String[] words) {
        if(!isContain(target, words)) return 0;
        boolean[] visited = new boolean[words.length];
        int answer = dfs(begin, target, words, 0, visited, words.length+1);
        return answer;
    }
}
