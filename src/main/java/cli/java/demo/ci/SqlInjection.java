package cli.java.demo.ci;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcDataSource;

public class SqlInjection {
    private Connection conn;

    public void connect() throws SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:database.db");
        conn = ds.getConnection();
        conn.createStatement().execute("CREATE TABLE IF NOT EXISTS users (id IDENTITY PRIMARY KEY, username VARCHAR(50), name VARCHAR(50), password VARCHAR(50))");
        conn.createStatement().execute("INSERT INTO users (username, name, password) VALUES ('admin', 'Administrator', 'passw0rd')");
        conn.createStatement().execute("INSERT INTO users (username, name, password) VALUES ('john', ' John', 'hello123')");
    }

    public ResultSet getUserByUsername(String searchValue) throws SQLException {
        if (searchValue.isEmpty()) {
            return null;
        }

        String query = String.format("SELECT * FROM users WHERE username='%s'", searchValue);
        return conn.createStatement().executeQuery(query);
    }
}
