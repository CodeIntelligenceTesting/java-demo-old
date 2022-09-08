package cli.java.demo.ci;
import java.io.*;

public class RemoteCodeExecution {
    public class Book implements Serializable {
        String title;
        String author;

        private void readObject(ObjectInputStream ois) throws IOException {
            title = ois.readUTF();
            author = ois.readUTF();
        }
    }

    public static Book deserialize(ByteArrayInputStream stream) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(stream);
        try {
            // Casting the result of readObject() occurs after the deserialization process ends
            // which make it possible to read any object and can lead to gadget chain attacks
            return (Book) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
