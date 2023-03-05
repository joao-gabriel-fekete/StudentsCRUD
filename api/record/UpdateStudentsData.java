package get.academic.api.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateStudentsData(
        @NotNull
        Long id,
        String name,
        String lastName,
        String email,
        String course,
        int timeStudyingEnglish
) {
}
