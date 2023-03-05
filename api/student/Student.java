package get.academic.api.student;

import get.academic.api.record.StudentsData;
import get.academic.api.record.UpdateStudentsData;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "student")
@Entity(name = "Student")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String course;
    private int timeStudyingEnglish;
    @Embedded
    private Text textData;

    private Boolean active;

    public Student(StudentsData studentsData) {
        this.active = true;
        this.name = studentsData.name();
        this.lastName = studentsData.lastName();
        this.email = studentsData.email();
        this.course = studentsData.course();
        this.timeStudyingEnglish = studentsData.timeStudyingEnglish();
        this.textData = new Text(studentsData);

    }

    public void updateData(UpdateStudentsData studentsDataForUpdate) {
        if(studentsDataForUpdate.name()  != null){
            this.name = studentsDataForUpdate.name();
        }
        if(studentsDataForUpdate.lastName()  != null){
            this.lastName = studentsDataForUpdate.lastName();
        }
        if(studentsDataForUpdate.email()  != null){
            this.email = studentsDataForUpdate.email();
        }
        if(studentsDataForUpdate.course()  != null){
            this.course = studentsDataForUpdate.course();
        }
        if(studentsDataForUpdate.timeStudyingEnglish() != 0){
            this.timeStudyingEnglish = studentsDataForUpdate.timeStudyingEnglish();
        }
    }

    public void changeStatus() {
        this.active = false;
    }
}
