import java.util.*;

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
        Map<String, Integer> totalMap = new HashMap<>();
        List<Music> list = new ArrayList<>();
        Map<String, List<Music>> musicSort = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
            if (musicSort.get(genres[i]) == null) {
                musicSort.put(genres[i], new ArrayList<>());
            }
            musicSort.get(genres[i]).add(new Music(i,plays[i]));
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(totalMap.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (String genre : musicSort.keySet()) {
            List<Music> musics = musicSort.get(genre);
            musics.sort((m1, m2) -> {
                if (m1.play == m2.play) return m1.index - m2.index;
                else return m2.play - m1.play;
            });
        }
        
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            List<Music> musics = musicSort.get(entry.getKey());
            int songsToAdd = Math.min(musics.size(), 2); // 해당 장르의 곡 수가 2 미만인 경우를 처리
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
