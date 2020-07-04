package Chapter3;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListSelectFiles {
    public static void main(String[] args) throws IOException {
        {
            // Imperative , old and verbose .Don't use this way in modern Java8
            final String[] files = new File("src/Chapter3")
                    .list(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".java");
                        }
                    });
            System.out.println(files);
        }
        Files.newDirectoryStream(
                Paths.get("src/Chapter3"),path->path.toString().endsWith(".java")
        ).forEach(System.out::println);
    }


}
