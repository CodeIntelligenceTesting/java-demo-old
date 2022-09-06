import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import cli.java.demo.ci.RemoteCodeExecution;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RemoteCodeExecutionFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        try {
            RemoteCodeExecution.deserialize(new ByteArrayInputStream(data.consumeBytes(100)));
        } catch (IOException ignored) {}
    }
}
