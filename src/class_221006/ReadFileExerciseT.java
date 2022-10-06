package class_221006;

import java.io.*;

public class ReadFileExerciseT {

    public void printFiles() {
        File dir = new File("./");
        File files[] = dir.listFiles();

        for(File file : files) {
            System.out.println(file);
        }
    }

    public char readAChar(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        return ((char)fileReader.read());

    }

    public String read2Char(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        String str = "";
        str += ((char)fileReader.read());
        str += ((char)fileReader.read());
        return str;

    }

    public String readNChar(String filename, int num) throws IOException {
        FileReader fileReader = new FileReader(filename);
        String str = "";

        for(int i = 0; i<num; i++) {

            /*
            if (fileReader.read() == -1 ) {
                break;
            }
             */

            char c = ((char) fileReader.read());
            str += c;

        }

        return str;

    }

    public String readALine(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader br = new BufferedReader(
                new FileReader(filename),
                16 * 1024
        );

        String str = br.readLine();

        return str;

    }
    public String readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader br = new BufferedReader(
                new FileReader(filename),
                16 * 1024
        );

        String str = "";
        String line;

        while((line = br.readLine()) != null) {
            str += line;
        }
        return str;

    }

    public static void main(String[] args) throws IOException {

        ReadFileExerciseT readFileExerciseT = new ReadFileExerciseT();

        char c = readFileExerciseT.readAChar("./a_file");
        String str = readFileExerciseT.read2Char("./a_file");
        String str1 = readFileExerciseT.readNChar("./a_file",10);
        String str2 = readFileExerciseT.readALine("./a_file");
        String str3 = readFileExerciseT.readLines("./a_file");

        System.out.println(str1);
        System.out.println(str2);

    }
}

/*
.\.git
.\.gitignore
.\.idea
.\a_file
.\like-lion-2.iml
.\out
.\src
 */
