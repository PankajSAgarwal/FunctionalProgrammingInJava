package Chapter3;

import java.io.File;
import java.util.Arrays;

public class ListHiddenFiles {
    public static void main(String[] args) {
        final File[] files = new File(".")
                .listFiles(File::isHidden);//File::isHidden <-> file -> file.isHidden()

        Arrays.stream(files).forEach(System.out::println);

    }
}
