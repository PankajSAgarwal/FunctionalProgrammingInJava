package Chapter5;

import com.sun.tools.classfile.ConstantPool;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {

    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
    }

    private void close() throws IOException {
        System.out.println("close called automatically ...");
        writer.close();
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public static void use(final String fileName,final UseInstance<FileWriterEAM, IOException> block)
        throws IOException{

        FileWriterEAM writerEAM = new FileWriterEAM(fileName);
        try {
            block.accept(writerEAM);
        } finally {
            writerEAM.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("//" + "START:EAM_USE_OUTPUT");
        FileWriterEAM.use("eam.txt",writerEAM -> writerEAM.writeStuff("sweet"));
        FileWriterEAM.use("eam2.txt", writerEAM -> {
            writerEAM.writeStuff("how");
            writerEAM.writeStuff("sweet");
        });
    }

}
