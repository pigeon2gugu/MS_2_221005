package class_221006;

import java.io.File;
import java.io.FileNotFoundException;

public class ReadFileExerciseT {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("./");
        File files[] = dir.listFiles();

        for(File file : files) {
            System.out.println(file);
        }

        //FileReader fileReader = new FileReader("C:\\Users\\Administrator\\git\\like-lion-2\\a_file");
    }
}
