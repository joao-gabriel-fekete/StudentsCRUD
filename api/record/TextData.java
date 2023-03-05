package get.academic.api.record;

import jakarta.validation.constraints.NotBlank;

public record TextData(
        @NotBlank
        String title,
        @NotBlank
        String text
) {
}
