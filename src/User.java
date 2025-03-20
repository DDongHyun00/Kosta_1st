import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private final int uniqueNumber = 0; // 개인 고유번호
    private static int userCount = 0; //고유번호 ++
    private String name; // 이름
    private String gender; // 성별
    private int age; // 나이
    private int userid; // 아이디
    private int passwd; // 비밀번호
    private String userInput; // 사용자가 입력한 감정 문장

    private static final Map<String, User> userDatabase = new HashMap<>();




    public int getage(){
        return age;
    }
    public String getgender(){
        return gender;
    }


    public void getUserSituation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("성별을 입력하세요. \n =>");
        gender = sc.nextLine();
        System.out.print("나이를 입력하세요. \n =>");
        age = sc.nextInt();
        System.out.printf(gender + " ");
        System.out.print(age);
        sc.close();

    }
}
