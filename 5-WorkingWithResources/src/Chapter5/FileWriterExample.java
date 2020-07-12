package Chapter5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    private FileWriter writer;

    public FileWriterExample(final String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void finalize() throws IOException {
        writer.close();
    }

    public void close() throws IOException {
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        FileWriterExample writerExample = new FileWriterExample("peekaboo.txt");
        try {
            writerExample.writeStuff("peek-a-boo");
        } finally {
            writerExample.close();
        }
    }
}
