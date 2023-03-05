package get.academic.api.student;

import get.academic.api.record.StudentsData;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Text {
        private String title;
        private String text;

        public Text(StudentsData studentsData) {
                this.title = studentsData.textData().title();
                this.text = studentsData.textData().text();
        }


}

