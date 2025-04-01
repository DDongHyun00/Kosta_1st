import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList {


    // gpt한테 받아온 감정과 음악을 담을 Map 생성
    private static Map<String, List<String>> playList = new HashMap();

    public void printPlayList() {
        for (Map.Entry<String, List<String>> entry : playList.entrySet()) {
            System.out.println("감정: " + entry.getKey());
            for (String music : entry.getValue()) {
                System.out.println("음악: " + music);
            }
            System.out.println(); // 감정별 줄 구분
        }
    }


    public void addMusicList(String emotionInput, ChatGPTResponse result) {
        List<String> all = new ArrayList<>();
        all.add(result.getMood());
        all.addAll(result.getMusicList()); // 노래 3곡 추가
        playList.put(emotionInput, all);
    }

}