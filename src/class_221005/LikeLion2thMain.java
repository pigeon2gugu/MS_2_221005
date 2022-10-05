package class_221005;

import java.util.List;

public class LikeLion2thMain {
    public static void main(String[] args) {
        LikeLion2th likeLion2th = new LikeLion2th();
        List<String> students = likeLion2th.getStudentList();
        List<LikeLion2thStudent> studentobjs = likeLion2th.getStudentObjs();

        //for each
        for (String student : students) {
            System.out.println(student);
        }

        for (LikeLion2thStudent studentobj : studentobjs) {
            System.out.println(studentobj.classNo);
        }

        //list에 들어있는 element 개수 세기
        System.out.println(students.size());
    }
}
