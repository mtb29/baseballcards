package simpleDBTest;

import java.sql.*;
public class simpleDB {

    public static void main(String[] args) {
        final String QUERY = "SELECT * FROM CARDS";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/baseballcards", "river", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                        rs.getInt("cardID") + ", "
                        + rs.getString("cardLName") + ", "
                        + rs.getString("cardFName") + ", "
                        + rs.getString("cardStatus") + ", "
                        + rs.getInt("cardYear"));
            }
        } catch (SQLException ex) {
            System.out.println("retrieve SQLException: " + ex.getMessage());
        }
    }
}
