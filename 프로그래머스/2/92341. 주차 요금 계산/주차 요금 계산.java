import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int BASIC_TIME = fees[0];
        int BASIC_FEE = fees[1];
        int CAL_TIME = fees[2];
        int CAL_FEE = fees[3];
        
        Map<String, Data> map = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for(String str : records) {
            String[] record = str.split(" ");
            String carNumber = record[1];
            String time = record[0];
            String type = record[2];
            
            if(!map.containsKey(carNumber)) {
                map.put(carNumber, new Data(time, 0));
            } else {
                Data data = map.get(carNumber);
                if(type.equals("IN")) {
                    data.time = time;
                } else {
                    LocalTime time1 = LocalTime.parse(data.time, formatter);
                    LocalTime time2 = LocalTime.parse(time, formatter);
                    Duration duration = Duration.between(time1, time2);
                    data.total += duration.toMinutes();
                    data.time = null; // 시간 초기화
                }
            }
        }
        
        // 출차되지 않은 차량 처리 (23:59 출차 간주)
        LocalTime endOfDay = LocalTime.parse("23:59", formatter);
        for(String carNumber : map.keySet()) {
            Data data = map.get(carNumber);
            if(data.time != null) {
                LocalTime time1 = LocalTime.parse(data.time, formatter);
                Duration duration = Duration.between(time1, endOfDay);
                data.total += duration.toMinutes();
            }
        }

        // 차량 번호를 정렬
        List<String> carNumbers = new ArrayList<>(map.keySet());
        Collections.sort(carNumbers);
        
        // 비용 산정
        List<Integer> result = new ArrayList<>();
        for(String carNumber : carNumbers) {
            Data data = map.get(carNumber);
            int totalMinutes = data.total;
            int fee = BASIC_FEE;
            if(totalMinutes > BASIC_TIME) {
                fee += Math.ceil((double)(totalMinutes - BASIC_TIME) / CAL_TIME) * CAL_FEE;
            }
            result.add(fee);
        }
        
        // 결과를 int 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}

class Data {
    String time;
    int total;
    
    public Data(String time, int total) {
        this.time = time;
        this.total = total;
    }
}