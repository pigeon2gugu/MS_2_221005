package class_221006;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExercise3 {

    private String filename;

    public ReadFileExercise3(String filename) {
        this.filename = filename;
    }

    String readNByte(int num) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(this.filename),
                16 * 1024
        );

        String s1 ="";

        for(int i=0 ; i<num; i++) {
            s1 += Character.toString((char)(br.read()));
        }

        return s1;
    }
    public static void main(String[] args) throws IOException {
        ReadFileExercise3 readFileExercise = new ReadFileExercise3("C:\\Users\\Administrator\\git\\like-lion-2\\a_file");
        String s = readFileExercise.readNByte(5);
        System.out.println(s);
    }
}
