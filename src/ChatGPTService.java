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
                + "1.[노래 제목] - [아티스트] - [유튜브 링크] "
                + "2.[노래 제목] - [아티스트] - [유튜브 링크] "
                + "3.[노래 제목] - [아티스트] - [유튜브 링크] ";




        return "";
    }
}
