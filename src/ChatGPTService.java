import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;

public class ChatGPTService {
    private static final String API_KEY = "";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    public static String getEmotion(User user, String userInput) throws Exception{
        String prompt = "사용자 정보\n"
                + "성별:" + user.getgender() + "\n"
                + "나이:" + user.getage() + "\n"
                + "사용자가 입력한 감정 문장:" + userInput + "\n"
                + "이 정보를 고려해서 제일 적절한 노래 3가지 추천해줘 \n"
                + "3가지 노래 추천 형식은 다음과 같아 \n"
                + "사용자의 감정은 [감정] - 세부감정은 [세부감정]\n"
                + "1.[노래 제목] - [아티스트] - [유튜브 링크]\n"
                + "2.[노래 제목] - [아티스트] - [유튜브 링크]\n"
                + "3.[노래 제목] - [아티스트] - [유튜브 링크]";

        JSONObject requestbody = new JSONObject();
        requestbody.put("model","gpt-3.5 Turbo");

        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role","system").put("content","넌 감정 분석 및 음악 추천하는 AI야"));
        messages.put(new JSONObject().put("role","user").put("content",userInput));

        requestbody.put("message",messages);


        //새로운 HTTP 요청 생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Authorization","Bearer " + "API_KEY")  //"API_KEY에 자신 API 입력
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestbody.toString()))
                .build();

        JSONObject jsonObject = new JSONObject(requestbody);
        JSONArray choices = jsonObject.getJSONArray("choices");
        String responseText = choices.getJSONObject(0).getJSONObject("message").getString("content");

        String[] musicList = responseText.split("\n");

        for (String s : musicList) {   // 음악 3개 리스트 출력
            System.out.println(s);
        }

        return "";
    }
}
