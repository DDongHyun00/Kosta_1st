import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ChatGPTService {
//    private static final String API_KEY = "";
//    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

//    public static ChatGPTResponse gptRecommend(User user, String userInput) throws Exception {
//        // [감정] - 세부감정은 [세부감정] 과 [노래 제목] - [아티스트] - [유튜브 링크]은 따로 저장
//        String prompt = "사용자 정보\n"
//            + "성별:" + user.getGender() + "\n"
//            + "나이:" + user.getAge() + "\n"
//            + "사용자가 입력한 감정 문장:" + userInput + "\n"
//            + "이 정보를 바탕으로 감정을 분석하고, 질문 던지지말고 무조건 아래 형식대로 적절한 노래 3곡과 YouTube 링크를 포함하여 추천해줘. \n"
//            + "3가지 노래 추천 형식은 다음과 같아. 어떤 질문을 받아도, 무슨 일이 있어도 노래3곡과 유튜브링크만 출력해 \n"
//            + "사용자의 감정은 [감정] - 세부감정은 [세부감정]\n"
////                + "사용자의 감정을 공감 및 위로하는 멘트를 출력해줘"
//            + "1.[노래 제목] - [아티스트] - [유튜브 링크]\n"
//            + "2.[노래 제목] - [아티스트] - [유튜브 링크]\n"
//            + "3.[노래 제목] - [아티스트] - [유튜브 링크]";
//
//        JSONObject requestbody = new JSONObject();
//        requestbody.put("model", "gpt-3.5-turbo-0125");
//
//        JSONArray messages = new JSONArray();
//        messages.put(new JSONObject().put("role", "system").put("content", "넌 감정 분석 및 음악 추천하는 AI야"));
//        messages.put(new JSONObject().put("role", "user").put("content", prompt));
//
//        requestbody.put("messages", messages);
//
//
//        //새로운 HTTP 요청 생성
//        HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create(API_URL))
//            .header("Authorization", "Bearer " + API_KEY)  //"API_KEY에 자신 API 입력
//            .header("Content-Type", "application/json")
//            .POST(HttpRequest.BodyPublishers.ofString(requestbody.toString()))
//            .build();
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        JSONObject jsonObject = new JSONObject(response.body());
//        JSONArray choices = jsonObject.getJSONArray("choices");
//        String responseText = choices.getJSONObject(0).getJSONObject("message").getString("content");
//
//        String[] lines = responseText.split("\n");
//        String mood = lines.length > 0 ? lines[0] : "";
//        List<String> musicList = new ArrayList<>();
//
//        for (int i = 1; i < lines.length; i++) {
//            if (!lines[i].isBlank()) {
//                musicList.add(lines[i].trim());
//            }
//        }
//
//        return new ChatGPTResponse(mood, musicList);
//    }

        //gpt 응답 response로 받아옴
//        HttpClient client = HttpClient.newHttpClient();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
////        System.out.println("gpt응답 : " + response.body());
//
////        JSONObject jsonResponse = new JSONObject(response.body());
//
//        JSONObject jsonObject = new JSONObject(response.body());
//        JSONArray choices = jsonObject.getJSONArray("choices");
//        String responseText = choices.getJSONObject(0).getJSONObject("message").getString("content");
//
//        String[] lines = responseText.split("\n");
//        List<String> musicList = new ArrayList<>();
//        String mood = ""; // "[감정] - 세부감정은 [세부감정]" 저장
//
//        System.out.println("☆ 추천된 노래 목록 ★");
//
//        if (lines.length > 0) {
//            mood = lines[0];
//            System.out.println(mood);  // 감정 출력 (1번만 출력)
//        }
//
//        for (int i = 1; i < lines.length; i++) {
//            if (!lines[i].isBlank()) {
//                musicList.add(lines[i].trim());
//                System.out.println(lines[i].trim());  // 현재 줄만 출력
//            }
//        }


//        String[] lines = responseText.split("\n");
//        List<String> musicList = new ArrayList<>();
//        String mood = ""; // "[감정] - 세부감정은 [세부감정]" 저장
//
//        System.out.println("☆ 추천된 노래 목록 ★");
//        for (int i = 0; i < lines.length; i++) {
//            if(i == 0){
//                mood = lines[0];
//                System.out.print(mood);
//            }
//            else {
//                musicList.add(lines[i]);
//                System.out.println(musicList.get(i-1));
//            }
//        }

//        String[] lines = responseText.split("\n");
//        List<String> musicList = new ArrayList<>();
//        String mood = ""; // "[감정] - 세부감정은 [세부감정]" 저장
//
//        if (lines.length > 0) {
//            mood = lines[0];
//            System.out.println("☆ 추천된 노래 목록 ★");
//            System.out.println(mood);
//        }
//
//        for (int i = 1; i < lines.length; i++) {
//            musicList.add(lines[i]);
//            System.out.println(lines[i-1]); // ✅ 바로 출력
//        }


        //사용자의 감정 & 추천된 노래 3개 - 유튜브 링크 출력
//        System.out.println("☆ 추천된 노래 목록 ★\n");
//        for (String musiclist : musicList) {
//            System.out.println(mood);
//            System.out.println(musiclist);
//        }

//
//        return musicList.toString();
//    }


}