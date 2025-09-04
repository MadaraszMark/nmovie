package hu.nmovie.main.dto;

import org.hibernate.validator.constraints.URL;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Film frissítéséhez szükséges DTO")
public class NMovieUpdateRequest {

    @Size(max = 200, message = "A cím legfeljebb 200 karakter lehet.")
    private String title;

    @Min(1888)
    private Integer releaseYear;	// Integer int helyett -> null mező nem kerül küldésre

    @Positive
    @Max(value = 600, message = "A filmhossz legfeljebb 600 perc lehet.")
    private Integer runtimeMin;

    @Size(min = 10, message = "A leírás legyen legalább 10 karakter.")
    private String plot;

    @Size(max = 2048)
    @URL(message = "A poszter URL nem érvényes.")
    private String posterUrl;
}