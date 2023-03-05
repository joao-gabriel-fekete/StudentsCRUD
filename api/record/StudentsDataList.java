package get.academic.api.record;

import get.academic.api.student.Student;

public record StudentsDataList(Long id, String name, String lastName, String email, String course, int timeStudyingEnglish) {

    public StudentsDataList(Student student){
        this(student.getId(), student.getName(), student.getLastName(), student.getEmail(), student.getCourse(), student.getTimeStudyingEnglish());
    }

}
