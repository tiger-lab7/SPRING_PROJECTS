import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleJDBC {
    public static final String dbPath = "jdbc:postgresql://localhost:5432/postgres";
    public static final String user = "postgres";
    public static final String password = "password";

    @SneakyThrows
    public static void main(String[] args) {

        Connection connection = DriverManager.getConnection(dbPath, user, password);
        Statement statement = connection.createStatement();
        //statement.execute("DELETE FROM computers_list");
        ResultSet resultSet =
                statement.executeQuery("SELECT COALESCE(vendor, 'NULL'), COALESCE(memory, 0) FROM computers_list");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getLong(2));
        }

        statement.close();
        connection.close();
    }
}
