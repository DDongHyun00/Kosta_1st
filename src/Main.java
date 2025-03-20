import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n \uD83C\uDFB5 GPT Music Service");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원 목록 조회 | 4. 종료");
            System.out.print("선택 (※숫자를 입력해주세요) : ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> User.registerUser();

                default -> System.out.println("❌ 잘못된 입력입니다.");
            }



        }

    }
}