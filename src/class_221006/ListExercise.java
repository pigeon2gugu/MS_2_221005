package class_221006;

import java.util.ArrayList;
import java.util.List;

public class ListExercise {
    private List<String> students;

    public ListExercise() {
        //System.out.println(students);
        this.students = new ArrayList<>();
        this.students.add("김하늘");
        this.students.add("김미지");
        this.students.add("김민경");
        this.students.add("김민지");
    }

    public List<String> getStudents() {
        return students;
    }
}
