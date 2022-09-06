import com.code_intelligence.jazzer.api.FuzzedDataProvider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class RemoteCodeExecutionFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        try {
            RemoteCodeExecution.deserialize(new ByteArrayInputStream(data.consumeBytes(100)));
        } catch (Exception ignored) {}
    }
}
