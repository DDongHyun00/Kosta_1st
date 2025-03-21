import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        System.out.println("\n \uD83C\uDFB5 GPT Music Service");
        System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원 목록 조회 | 4. 종료");
        System.out.print("원하는 서비스를 선택해주세요.(※숫자를 입력해주세요) : ");

        do {

            switch (choice) {
                case 1 -> User.registerUser();
                case 2 -> {
                    User loggedInUser = User.loginUser();
                    if (loggedInUser != null) {
                        User.UserDisplay();
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

//        while (true) {
//            System.out.println("\n \uD83C\uDFB5 GPT Music Service");
//            System.out.println("1. 감정입력 | 2. 플레이리스트 확인 | 3. 로그아웃");
//            System.out.print("원하는 서비스를 선택해주세요.(※숫자를 입력해주세요) : ");
//
//            Scanner scanner = new Scanner(System.in);
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//
//            }
//        }

    }
}