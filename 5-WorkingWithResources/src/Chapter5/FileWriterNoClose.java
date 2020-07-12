package Chapter5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

/*
noclose.txt doesn't have any text because finalize method is not called as compiler assumes there is sufficient memory.
This should not be used.
 */
public class FileWriterNoClose {
    private FileWriter writer;

    public FileWriterNoClose(String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
    }

    public void writeStuff(String message) throws IOException {
        writer.write(message);
    }

    public void finalize() throws IOException {
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        try {
            FileWriterNoClose writerExample = new FileWriterNoClose("noclose.txt");
            writerExample.writeStuff("peek-a-boo");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
