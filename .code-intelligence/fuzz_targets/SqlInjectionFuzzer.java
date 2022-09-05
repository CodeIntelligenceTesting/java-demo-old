import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import java.sql.SQLException;
import cli.java.demo.ci.SqlInjection;
public class SqlInjectionFuzzer {

    private static SqlInjection project;

    public static void fuzzerInitialize() throws SQLException {
        project = new SqlInjection();
        project.connect();
    }

    public static void fuzzerTestOneInput(FuzzedDataProvider data) throws SQLException {
        project.getUserByUsername(data.consumeString(50));
    }
}
