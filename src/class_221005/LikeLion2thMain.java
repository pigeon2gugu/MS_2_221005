package class_221005;

import java.util.List;

public class LikeLion2thMain {
    public static void main(String[] args) {
        LikeLion2th likeLion2th = new LikeLion2th();
        List<String> students = likeLion2th.getStudentList();

        //for each
        for (String student : students) {
            System.out.println(student);
        }

        //list에 들어있는 element 개수 세기
        System.out.println(students.size());
    }
}
