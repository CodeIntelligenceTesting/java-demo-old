import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import cli.java.demo.ci.RemoteCodeExecution;

public class RemoteCodeExecutionFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        try {
            RemoteCodeExecution.deserialize(new ByteArrayInputStream(data.consumeBytes(100)));
        } catch (Exception ignored) {}
    }
}
