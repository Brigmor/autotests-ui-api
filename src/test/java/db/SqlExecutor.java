package db;

import java.sql.Connection;
import java.sql.SQLException;

public class SqlExecutor {

    public static void deleteApplication(String applicationId) {
        String sql = "DELETE FROM applications WHERE id = ?";

        try (Connection connection = DATA_SOURCE.getConnection();
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, applicationId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось удалить заявку", e);
        }
    }
}
