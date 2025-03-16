import java.util.Scanner;

public class UserInput {
    public static String getUserSituation(){
        String situation = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("오늘의 감정을 입력하세요. \n =>");
        situation = sc.nextLine();
        sc.close();
        return situation;
    }
}
