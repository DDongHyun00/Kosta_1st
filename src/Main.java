import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0; // 처음 공백 위해 선언

        System.out.println("\uD83C\uDFB5 GPT Music Service");
        String mainMention = """
                    ================================================
                    1. 회원가입 | 2. 로그인 | 3. 회원 목록 조회 | 4. 종료
                      원하는 서비스를 선택해주세요.(※숫자를 입력해주세요)
                    ================================================
                    """;
        do {
            if(cnt == 0) cnt++;
            else System.out.print("\n");
            System.out.print(mainMention);
            System.out.print("=> ");
            int choice = scanner.nextInt();
            System.out.print("");

            switch (choice) {
                case 1 -> User.registerUser();
                case 2 -> {
                    User loggedInUser = User.loginUser();
                    if (loggedInUser != null) {
                        User.UserDisplay(loggedInUser);
                    } else {
                        System.out.println("🎶 로그인 후 음악 추천 서비스 이용 가능!");
                    }
                }

                case 3 -> User.displayAllUsers();
                case 4 -> {
                    System.out.println("프로그램이 종료됩니다.");
                    System.exit(0);
                }
                default -> System.out.println("❌ 잘못된 입력입니다.");
            }

        }
        while (true);


    }
}