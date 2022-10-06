package class_221006;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ReadFileExercise {

    private String filename;

    public ReadFileExercise(String filename) {
        this.filename = filename;
    }

    char readOneByte() throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(this.filename),
                16 * 1024
        );

        return (char)br.read();

    }
    public static void main(String[] args) throws IOException {
        ReadFileExercise readFileExercise = new ReadFileExercise("C:\\Users\\Administrator\\git\\like-lion-2\\a_file");
        char c = readFileExercise.readOneByte();
        System.out.println(c);
    }
}
