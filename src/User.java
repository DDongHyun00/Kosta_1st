import java.sql.*;
import java.util.*;

public class User {
    // 모든 사용자 정보
    private static int userCount = 0; // 사용자 총 개수( 고유번호 관리 )
    Connection conn = DBUtil.getConnection();
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO User(userid, password, userName, age, gender, userInput) VALUES (?, ?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS);  //RETURN_GENERATED_KEYS은 userNumber SQL에서 AI로 자동생성된번호 자바로 가져옴

    // 개별 사용자 정보 (필드)
    private int userNumber;
    private String userid;
    private String password;
    private String userName;
    private int age;
    private String gender;
    private String userInput;
    private PlayList playList = new PlayList();



    public int getUserNumber() { return userNumber; }
    public void setUserNumber(int userNumber) { this.userNumber = userNumber; }
    public String getUserid() { return userid; }
    public String getPassword() { return password; }
    public String getUserName() { return userName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getUserInput() { return userInput; }
    public void setUserInput(String userInput) { this.userInput = userInput; }
    public PlayList getPlayList() { return playList; }


    // 생성자 (회원가입시 사용)
    public User(String userid, String password, String userName, int age, String gender) throws SQLException {
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

                if (isUserExists(userid)) {
                    System.out.println("❌ 이미 존재하는 아이디입니다. 다시 시도해주세요.");
                } else {
                    break;
                }
            }

            System.out.print("비밀번호 : ");   //비밀번호 확인 추가!
            String password = scanner.nextLine();


            // while문 시작전에 변수 지정 및 초기화
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

            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO User(userid, password, userName, age, gender, userInput) VALUES (?, ?, ?, ?, ?, ?)",
                         Statement.RETURN_GENERATED_KEYS)) {

                stmt.setString(1, newUser.userid);
                stmt.setString(2, newUser.password);
                stmt.setString(3, newUser.userName);
                stmt.setInt(4, newUser.age);
                stmt.setString(5, newUser.gender);
                stmt.setString(6, null);

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    newUser.setUserNumber(rs.getInt(1));
                }

                System.out.println("✅ 회원가입 완료! " + newUser.userid + " 님 환영합니다.");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("❌ 입력 중 오류 발생: " + e.getMessage());
        }
    }

    // 로그인 기능
    static User loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n🔑 로그인 \n아이디 입력: ");
        String userid = scanner.nextLine();

        User user = null;
        String sql = "SELECT * FROM User WHERE userid = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userid);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                System.out.println("❌ 존재하지 않는 아이디입니다.");
                return null;
            }

            System.out.print("비밀번호 입력: ");
            String password = scanner.nextLine();

            if (rs.getString("password").equals(password)) {
                user = new User(
                        rs.getString("userid"),
                        rs.getString("password"),
                        rs.getString("userName"),
                        rs.getInt("age"),
                        rs.getString("gender")
                );
                user.setUserNumber(rs.getInt("userNumber"));
                user.setUserInput(rs.getString("userInput"));
                System.out.println("✅ 로그인 성공! " + user.userName + "님 환영합니다.");
                return user;
            } else {
                System.out.println("❌ 비밀번호가 틀렸습니다.");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static void displayAllUsers() {
        String sql = "SELECT * FROM User ORDER BY userNumber";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n 📌 전체 회원 목록");
            while (rs.next()) {
                System.out.println("고유번호: " + rs.getInt("userNumber") +
                        ", 아이디: " + rs.getString("userid") +
                        ", 이름: " + rs.getString("userName") +
                        ", 나이: " + rs.getInt("age") +
                        ", 성별: " + rs.getString("gender"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isUserExists(String userid) {
        String sql = "SELECT * FROM User WHERE userid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // 결과가 있으면 true → 중복 ID
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static void UserDisplay(User user) {
        Scanner scanner = new Scanner(System.in);
        boolean bool1 = true;
        PlayList playList = user.getPlayList();

        while (bool1) {
            System.out.println("\n 🎵 GPT Music Service");
            System.out.println("1. 노래추천 | 2. 플레이리스트 확인 | 3. 로그아웃");
            System.out.print("원하는 서비스를 선택해주세요.(※숫자를 입력해주세요) : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("노래 추천을 위해 현재 감정을 입력해주세요!");
                    System.out.print("=> ");
                    String input = scanner.nextLine();
                    user.setUserInput(input);

                    try {
                        ChatGPTResponse result = ChatGPTService.gptRecommend(user, user.getUserInput());
                        System.out.println("☆ 추천된 노래 목록 ★");
                        System.out.println(result.getMood());
                        for (String music : result.getMusicList()) {
                            System.out.println(music);
                        }
                        playList.saveToDB(user.getUserNumber(), result.getMood(), result.getMusicList());
                    } catch (Exception e) {
                        System.out.println("GPT 추천 중 오류 발생: " + e.getMessage());
                    }
                }
                case 2 -> playList.printFromDB(user.getUserNumber());
                case 3 -> {
                    System.out.println("메인으로 돌아갑니다.");
                    bool1 = false;
                }
                default -> System.out.println("❌ 올바른 숫자를 입력해주세요.");
            }
        }
    }
}