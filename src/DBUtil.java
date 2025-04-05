import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        String url = "";
        String user = "";
        String password = ""; // 환경에 맞게 변경

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
