import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
  // 모든 사용자 정보
  private static int userCount; // 사용자 총 개수( 고유번호 관리 )
  private static final Map<Integer, User> userDatabase = new HashMap<>(); // 회원정보 저장

  // 개별 사용자 정보 (필드)
  private static int userNumber = 0; // 유저 고유 번호(넘버)
  private String userid; // 유저 아이디
  private String password; // 유저 패스워드
  private String userName; // 유저 이름
  private int age; // 나이
  private String gender; // 성별
  private String userInput; // 감정입력

  // 생성자 (회원가입시 사용)


  public User(String userid, String password, String userName, int age, String gender) {
    this.userNumber = ++userCount; // 값을 입력받지않고 자동증가(기본키)
    this.userid = userid;
    this.password = password;
    this.userName = userName;
    this.age = age;
    this.gender = gender;

  }

  // 회원가입 기능
  static void registerUser() {
    // 입력해야하니 스캐너 클래스 이용
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n \uD83D\uDCDD 회원가입을 진행합니다.");
    System.out.print("아이디 : ");
    String userid = scanner.nextLine();

    // 아이디 중복체크 ( 아이디 키값이 존재하는지 확인)
    if (userDatabase.containsKey(userid)) {
      System.out.println("❌ 이미 존재하는 아이디입니다. 다시 시도해주세요.");
    }

    System.out.print("비밀번호 : ");
    String password = scanner.nextLine();
    System.out.print("이름 : ");
    String userName = scanner.nextLine();
    System.out.print("나이 : ");
    int age = scanner.nextInt();
    System.out.print("성별 (남/여) : ");
    String gender = scanner.nextLine();

    // 사용자 객체 생성 후 Map 에 저장
    User newUser = new User(userid,password,userName,age,gender);
    userDatabase.put(userNumber, newUser);
    System.out.println("✅ 회원가입 완료! " + newUser.userid + " 님 환영합니다.");
  }

  // 로그인 기능

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
