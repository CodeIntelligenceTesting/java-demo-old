import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import java.sql.SQLException;
import cli.java.demo.ci.SqlInjection;
import com.code_intelligence.jazzer.api.FuzzerSecurityIssueHigh;

public class SqlInjectionFuzzer {

    private static SqlInjection project;

    public static void fuzzerInitialize() throws SQLException {
        project = new SqlInjection();
        project.connect();
    }

    public static void fuzzerTestOneInput(FuzzedDataProvider data) throws SQLException {
        project.searchUsersBy(data.consumeString(100), data.consumeString(100));
    }
}
