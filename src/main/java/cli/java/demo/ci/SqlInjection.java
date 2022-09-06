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
        conn.createStatement().execute("CREATE TABLE IF NOT EXISTS users (id IDENTITY PRIMARY KEY, username VARCHAR(50))");
    }

    public ResultSet getUserByUsername(String username) throws SQLException {
        return conn.createStatement().executeQuery("SELECT * FROM users WHERE username='" + username + "'");
    }
}
