import java.util.Scanner;

public class User {
    public String name; // 이름
    public String gender; // 성별
    public int age; // 나이
    public int id; // 아이디
    public int passwd; // 비밀번호
    public int uniqueNumber; // 개인 고유번호

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
