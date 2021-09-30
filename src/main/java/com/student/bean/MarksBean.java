package com.student.bean;

import com.student.models.Mark;
import com.student.models.Student;

import java.util.List;
import java.util.Random;

public class MarksBean {
    public void awardMarks(List<Student> students,int examId){
        for (Student student:students) {
            Random random=new Random();
            int limit=100;
            int score=random.nextInt(limit);
            Mark marks=new Mark();
            marks.setScore(score);
            marks.setStudentId(student.getStudentId());
            marks.setExamId(examId);
            System.out.println(marks);

        }
    }
}
