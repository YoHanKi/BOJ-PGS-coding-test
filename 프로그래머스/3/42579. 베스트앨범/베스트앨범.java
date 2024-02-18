import java.util.*;

//인덱스와 플레이 수를 저장해줄 클래스 생성
class Music {
    public int index;
    public int play;
    Music(int index, int play) {
        this.index = index;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //가장 큰 장르를 찾을 totalMap
        Map<String, Integer> totalMap = new HashMap<>();
        //Music 클래스를 저장하고, musicSort에 저장할 리스트와 맵
        List<Music> list = new ArrayList<>();
        Map<String, List<Music>> musicSort = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            //getOrDefault로 가장 높은 플레이 장르 찾기
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            //장르가 null 이라면 new ArrayList 생성
            if (musicSort.get(genres[i]) == null) {
                musicSort.put(genres[i], new ArrayList<>());
            }
            //리스트에 Music 추가
            musicSort.get(genres[i]).add(new Music(i,plays[i]));
        }
        //totalMap을 내림차순으로 정렬하기 위해 entryset 추가
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(totalMap.entrySet());
        //Collections.sort의 두번째 파라미터는 람다식으로 정렬기준을 지정할 수 있음(Comarator 인스턴스 생성, compare 오버라이딩하는 방법이 있으나 너무 복잡함)
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        //musicSort 내부의 리스트를 돌면서 정렬
        for (String genre : musicSort.keySet()) {
            List<Music> musics = musicSort.get(genre);
            musics.sort((m1, m2) -> {
                if (m1.play == m2.play) return m1.index - m2.index;
                else return m2.play - m1.play;
            });
        }
        //장르가 1개인 경우도 있으므로 유동적인 ArrayList 사용
        List<Integer> result = new ArrayList<>();
        //정렬된 entries 를 사용하여 index를 result에 저장
        for (Map.Entry<String, Integer> entry : entries) {
            List<Music> musics = musicSort.get(entry.getKey());
            // 해당 장르의 곡 수가 2 미만인 경우 musics.size로 반복문 지정
            int songsToAdd = Math.min(musics.size(), 2); 
            for (int i = 0; i < songsToAdd; i++) {
                result.add(musics.get(i).index);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
