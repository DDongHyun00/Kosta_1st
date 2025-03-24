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
  void addMusicList(User user, String userInput) throws Exception {
    // ChatGPTService 객체 생성
    ChatGPTService gpt = new ChatGPTService();

    // getEmotion 메소드로 감정과 음악 목록 받아오기
    String mood = gpt.gptRecommend(user,userInput);// 여기서 mood는 감정 정보와 음악 목록이 함께 반환됨

    // 감정(mood)과 음악 목록(playList)을 playList에 추가
    List<String> musicList = new ArrayList<>();
    musicList.add(mood); // 감정을 첫 번째 요소로 추가

    playList.put(userInput, musicList); // 감정별로 musicList를 저장
  }

  // 플리 데이터 출력 메소드
  public void printPlayList() {
    // playList의 모든 감정별 음악 목록을 출력
    for (Map.Entry<String,List<String>> entry : playList.entrySet()) {
      System.out.println("감정" + entry.getKey()); // 키(감정)를 출력
      for (String music : entry.getValue()) {
        System.out.println("음악 : " + entry.getValue());
      }
    }
  }
}
