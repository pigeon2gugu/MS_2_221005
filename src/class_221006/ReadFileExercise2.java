package class_221006;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExercise2 {

    private String filename;

    public ReadFileExercise2(String filename) {
        this.filename = filename;
    }

    String readTwoByte() throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(this.filename),
                16 * 1024
        );

        return Character.toString((char)(br.read())) + Character.toString((char)(br.read()));

    }
    public static void main(String[] args) throws IOException {
        ReadFileExercise2 readFileExercise = new ReadFileExercise2("C:\\Users\\Administrator\\git\\like-lion-2\\a_file");
        String s = readFileExercise.readTwoByte();
        System.out.println(s);
    }
}
