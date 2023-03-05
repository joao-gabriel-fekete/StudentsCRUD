package get.academic.api.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record StudentsData(
        @NotBlank
        String name,
        @NotBlank
        String lastName,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String course,
        int timeStudyingEnglish,
        @Valid
        TextData textData

) {
}
