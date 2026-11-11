package utils;

import ru.bank.config.Config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    public static void deleteApplication(String applicationId) {
        String sql = "DELETE FROM applications WHERE id = ?";

        try (var connection = DriverManager.getConnection(
                Config.CONFIG_APP.dbUrl(),
                Config.CONFIG_APP.dbUsername(),
                System.getenv("DB_PASSWORD")
        );
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, applicationId);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось удалить заявку", e);
        }
    }
}
