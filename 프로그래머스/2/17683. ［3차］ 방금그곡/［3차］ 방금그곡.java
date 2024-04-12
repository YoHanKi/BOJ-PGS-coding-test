import java.util.*;
import java.time.*;

class Music {
    public String name;
    public String melody;
    
    public Music(String name, String melody) {
        this.name = name;
        this.melody = melody;
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxDuration = 0;

        m = m.replaceAll("C#", "c").replaceAll("D#", "d")
            .replaceAll("F#", "f").replaceAll("G#", "g")
            .replaceAll("A#", "a").replaceAll("B#", "b");

        for (String musicinfo : musicinfos) {
            String[] parts = musicinfo.split(",");
            LocalTime startTime = LocalTime.parse(parts[0]);
            LocalTime endTime = LocalTime.parse(parts[1]);
            String title = parts[2];
            String melody = parts[3];

            melody = melody.replaceAll("C#", "c").replaceAll("D#", "d")
                .replaceAll("F#", "f").replaceAll("G#", "g")
                .replaceAll("A#", "a").replaceAll("B#", "b");

            Duration duration = Duration.between(startTime, endTime);
            int playTime = (int) duration.toMinutes();

            StringBuilder fullMelody = new StringBuilder();
            int repeatCount = playTime / melody.length();
            int remainder = playTime % melody.length();

            for (int i = 0; i < repeatCount; i++) {
                fullMelody.append(melody);
            }
            fullMelody.append(melody.substring(0, remainder));

            
            if (fullMelody.toString().contains(m)) {
                if (playTime > maxDuration) {
                    maxDuration = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }
}