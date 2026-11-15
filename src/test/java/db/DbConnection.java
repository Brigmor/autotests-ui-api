package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.bank.config.Config;

public class DbConnection {
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

    public static void close() {
        DATA_SOURCE.close();
    }
}
