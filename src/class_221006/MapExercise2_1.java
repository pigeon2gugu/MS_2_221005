package class_221006;

public class MapExercise2_1 {

    public static boolean isAlphabet(char alpha) {
        if (((int)alpha >= 65&&(int)alpha >= 65+25 ) || ((int)alpha >= 97&&(int)alpha >= 97+25)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isAlphabet(';'));

    }
}
