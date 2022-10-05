package class_221005;

import java.util.ArrayList;
import java.util.List;

public class LikeLion2th {

    private List<String> students = new ArrayList<>();
    private List<LikeLion2thStudent> studentObjs = new ArrayList<>();

    LikeLion2thName likeLion2thName = new LikeLion2thName();

    public LikeLion2th() {
        this.students = likeLion2thName.getName();
        this.studentObjs = likeLion2thName.getStudentObjs();
    }

    // 멋사 2기 학생의 이름이 들어있는 list를 return하는 method
    public List<String> getStudentList() {
        return this.students;
    }

    public List<LikeLion2thStudent> getStudentObjs() {
        return this.studentObjs;
    }
}
