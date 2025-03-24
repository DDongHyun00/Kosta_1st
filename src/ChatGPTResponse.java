import java.util.List;

public class ChatGPTResponse {
  private String mood;
  private List<String> musicList;

  public ChatGPTResponse(String mood, List<String> musicList) {
    this.mood = mood;
    this.musicList = musicList;
  }

  public String getMood() {
    return mood;
  }

  public List<String> getMusicList() {
    return musicList;
  }
}
