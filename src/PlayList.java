import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList {
    // 목적 - 플레이리스트에 gpt한테 받아온 값 넣어놓기
    // 플리번호 , 제목 , 아티스트이름 , 유튜브 링크, 사용자감정입력값(String) , 감정분석값 (String),

    // gpt한테 받아온 감정과 음악을 담을 Map 생성
    private static Map<String, List<String>> playList = new HashMap();
    // ChatGPTService 클래스의 getEmotion 메소드 안에 생성된 musicList의 값을
    // gpt클래스에서 playList 메소드 호출해서 거기에 값을 넣어주는 코드를 추가해야함

    // 1. ChatGPTService 객체를 PlayList에서 직접 생성하는 방식
    void addMusicList(String mood, List<String>musicList) {
//        playList.put(mood, musicList); // 감정별로 musicList를 저장
        playList.put(mood, new ArrayList<>(musicList));  // 복사본 저장

    }

    // 플리 데이터 출력 메소드
    public void printPlayList() {
        if (playList.isEmpty()) {
            System.out.println("🎵 저장된 플레이리스트가 없습니다.");
            return;
        }

//        // playList의 모든 감정별 음악 목록을 출력
//        for (Map.Entry<String,List<String>> entry : playList.entrySet()) {
//            System.out.println("감정 : " + entry.getKey()); // 키(감정)를 출력
//            List<String> musicList = entry.getValue();
//
//            for (String music : musicList) {
//                System.out.println("음악 : " + music +"\n");
//            }
//        }
        if (playList.isEmpty()) {
            System.out.println("🎵 저장된 플레이리스트가 없습니다.");
            return;
        }

        for (Map.Entry<String, List<String>> entry : playList.entrySet()) {
            String mood = entry.getKey();
            List<String> songs = entry.getValue();

            System.out.println("\n📌 플레이리스트 : " + mood); // 감정 설명 줄
            for (String song : entry.getValue()) {
                System.out.println("🎵 " + song); // 한 줄씩 노래 출력
            }
        }

    }



}