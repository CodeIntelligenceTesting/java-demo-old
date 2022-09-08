import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import cli.java.demo.ci.RemoteCodeExecution;
import java.io.ByteArrayInputStream;
import java.lang.Exception;

public class RemoteCodeExecutionFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        try {
            RemoteCodeExecution.deserialize(new ByteArrayInputStream(data.consumeBytes(100)));
        } catch (Exception ignored) {
            // We can ignore all exception as the RCE will be caught by Jazzer
        }
    }
}
