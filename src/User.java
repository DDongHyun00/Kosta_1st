import java.util.*;

public class User {
  // 모든 사용자 정보
  private static int userCount = 0; // 사용자 총 개수( 고유번호 관리 )
  private static final Map<String, User> userDatabase = new HashMap<>(); // 회원정보 저장

  // 개별 사용자 정보 (필드)
  private final int userNumber; // 유저 고유 번호(넘버)
  private String userid; // 유저 아이디
  private String password; // 유저 패스워드
  private String userName; // 유저 이름
  private int age; // 나이
  private String gender; // 성별
  private String userInput; // 감정입력

  public int getAge(){
    return age;
  }
  public String getGender(){
    return gender;
  }

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
    try {
      // 입력해야하니 스캐너 클래스 이용
      Scanner scanner = new Scanner(System.in);

      System.out.println("\n \uD83D\uDCDD 회원가입을 진행합니다.");

      String userid;
      while (true) {
        System.out.print("아이디 : ");
        userid = scanner.nextLine();

        // 아이디 중복체크 ( 아이디 키값이 존재하는지 확인)

        if (userDatabase.containsKey(userid)) {
          System.out.println("❌ 이미 존재하는 아이디입니다. 다시 시도해주세요.");
        } else {
          break;
        }
      }

      System.out.print("비밀번호 : ");   //비밀번호 확인 추가!
      String password = scanner.nextLine();

      // while문 시작전에 변수 지정및 초기화
      String userName;
      int age = 0;
      String gender;

      // 예외처리 while문으로 하기
      while (true) {
        // 이름에 공백이나 숫자가 입력받으면 다시 name을 입력받게하기
        System.out.print("이름 : ");
        userName = scanner.nextLine().trim(); // trim - 입력값앞뒤공백제거

        // 이름의 입력값이 비었거나, 숫자가포함되면 경고문구표시
        if (userName.isEmpty() || !userName.matches("^[a-zA-Z가-힣]+$")) {
          System.out.println("이름에는 문자만 입력할 수 있습니다.");
        } else {
          break;
        }
      }

      // 나이를 입력할때 정수만 입력받게하기
      while (true) {
        System.out.print("나이 : ");
        if (scanner.hasNextInt()) {
          age = scanner.nextInt();
          scanner.nextLine();  // 버퍼에 남아있는 개행 문자 제거

          // 나이 검증 추가 (나이가 음수일 경우)
          if (age < 0) {
            System.out.println("나이는 양의 정수여야 합니다.");
          } else {
            break;
          }
        } else {
          System.out.println("나이는 정수만 입력할 수 있습니다.");
          scanner.nextLine();  // 잘못된 입력 처리 후 버퍼 정리
        }
      }


      // 성별 - 남자 또는 여자만 입력받게하기
      while (true) {
        System.out.print("성별 (남자/여자) : ");
        gender = scanner.nextLine().trim();

        // 성별이 "남자" 또는 "여자"가 아닌 경우
        if (!gender.equals("남자") && !gender.equals("여자")) {
          System.out.println(" \"남자\" 또는 \"여자\" 로 입력해주세요. ");
          continue;  // 잘못된 성별 입력 시 다시 입력받도록 반복
        } else {
          break;
        }
      }


      // 사용자 객체 생성 후 Map 에 저장
      User newUser = new User(userid,password,userName,age,gender);
      userDatabase.put(userid, newUser);

      System.out.println("✅ 회원가입 완료! " + newUser.userid + " 님 환영합니다.");
    } catch (InputMismatchException e) {
      System.out.println("나이를 입력할때는 숫자를 입력해주세요.");
    }
  }

  // 로그인 기능



  // 모든 회원 목록 출력
  static void displayAllUsers() {
    // Map은 *키-값 쌍(key-value pair)* 로 구성되어 있으며,
    // 기본적으로 순서가 보장되지 않습니다.
    // 즉, HashMap과 같은 Map 구현체에서는 값들이 삽입된 순서대로 나열되지 않습니다.
    System.out.println("\n \uD83D\uDCCC 전체 회원 목록");

    // userDatabase의 값들을 리스트로 변환
    List<User> userList = new ArrayList<>(userDatabase.values());

    // userList를 userNumber를 기준으로 오름차순 정렬
    userList.sort(Comparator.comparingInt(user -> user.userNumber));

    for(User user : userList) {
      System.out.println("고유번호: "+user.userNumber+", 아이디: "+user.userid+
          ", 이름: "+user.userName+", 나이: "+user.age+", 성별: "+user.gender);
    }
  }



}
