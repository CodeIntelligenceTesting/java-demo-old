package cli.java.demo.ci;
import java.io.*;

public class RemoteCodeExecution {
    public static class Book implements Serializable {
        private static final long serialVersionUID = 123456789L;
        public String title;
        public String author;

        public Book(String title, String author) {
            title = title;
            author = author;
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            title = (String) ois.readObject();
            author = (String) ois.readObject();
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
