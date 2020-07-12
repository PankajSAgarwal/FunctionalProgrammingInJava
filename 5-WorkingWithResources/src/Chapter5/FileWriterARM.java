package Chapter5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterARM implements AutoCloseable{

    private final FileWriter writer;

    public FileWriterARM(final String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }


    @Override
    public void close() throws IOException {
        System.out.println("Closed called automatically");
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        try (FileWriterARM writerARM =
                     new FileWriterARM("peekaboo.txt")){
            writerARM.writeStuff("peek-a-boo");
            System.out.println("done with the resource ...");
        }
    }

}
