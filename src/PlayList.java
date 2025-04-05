import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList {

    public void saveToDB(int userNumber, String mood, List<String> musicList) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String music : musicList) {
            sb.append(count++).append(". ").append(music).append("\n");
        }

        String sql = "INSERT INTO PlayList(userNumber, mood, musicList) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userNumber);
            stmt.setString(2, mood);
            stmt.setString(3, sb.toString());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printFromDB(int userNumber) {
        String sql = "SELECT mood, musicList FROM PlayList WHERE userNumber = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userNumber);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n🎧 사용자 추천 플레이리스트");
            while (rs.next()) {
                System.out.println("감정 분석 결과: " + rs.getString("mood"));
                System.out.println("추천 노래 목록:\n" + rs.getString("musicList"));
                System.out.println("-----");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}