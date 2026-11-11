
package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.bank.config.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final HikariDataSource DATA_SOURCE = createDataSource();

    private static HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(Config.CONFIG_APP.dbUrl());
        config.setUsername(Config.CONFIG_APP.dbUsername());
        config.setPassword(System.getenv("DB_PASSWORD"));

        config.setMaximumPoolSize(5);
        config.setMinimumIdle(2);

        return new HikariDataSource(config);
    }

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

    public static void close() {
        DATA_SOURCE.close();
    }
}
