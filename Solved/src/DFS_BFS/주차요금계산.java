package DFS_BFS;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        // 기본 시간과 요금
        int basicTime = fees[0];
        int basicFee = fees[1];
        // 단위 시간과 요금
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 차량 번호 같은 것끼리 묶어 저장
        // ex) "05:34 5961 IN" -> "5961 05:34 IN"
        records = Arrays.stream(records).map(record -> {
            String[] recordArr = record.split(" ");
            return recordArr[1] + " " + recordArr[0] + " " + recordArr[2];
        }).toArray(String[]::new);

        // 차량별 누적 시간
        Map<String, Integer> totalTime= new HashMap<>();
        for(int i = 0 ; i < records.length ; i++){
            String currentKey = records[i].split(" ")[0];

            // totalTime에 차량번호가 없다면, 새로운 차량이므로 0으로 초기화
            if(!totalTime.containsKey(currentKey)){
                totalTime.put(currentKey, 0);
            }

            String time = records[i].split(" ")[1];
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);

            //IN이라면, 현재 시간을 분단위로 음수로 저장하기.
            if(records[i].split(" ")[2].equals("IN")){
                totalTime.put(currentKey, totalTime.get(currentKey) + -1 * (hour * 60 + minute));
            } else {
                //OUT이라면, 현재 시간을 분단위로 양수로 저장하기.
                totalTime.put(currentKey, totalTime.get(currentKey) + (hour * 60 + minute));
            }
        }

        // totalTime을 차량번호 오름차순으로 정렬(TreeMap은 key값을 기준으로 오름차순 정렬)
        totalTime = new TreeMap<>(totalTime);

        int[] answer = new int[totalTime.size()];
        int i = 0;
        for(String key: totalTime.keySet()) {
            // 차량이 OUT이 안된 경우, 23:59에 OUT된 것으로 간주
            if (totalTime.get(key) <= 0) {
                totalTime.put(key, totalTime.get(key) + 23 * 60 + 59);
            }
            // 기본 시간이하라면, 기본 요금을 청구
            if (totalTime.get(key) <= basicTime) {
                answer[i++] = basicFee;
            } else { // 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구
                // 이때, 단위 시간으로 나누어 떨어지지 않으면, 올림하여 청구
                if ((totalTime.get(key) - basicTime) % unitTime == 0) {
                    answer[i++] = basicFee + (totalTime.get(key) - basicTime) / unitTime * unitFee;
                } else {
                    answer[i++] = basicFee + (totalTime.get(key) - basicTime) / unitTime * unitFee + unitFee;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        주차요금계산 test = new 주차요금계산();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(test.solution(fees, records));
    }
}
