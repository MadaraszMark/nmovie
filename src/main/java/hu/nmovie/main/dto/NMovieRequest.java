package hu.nmovie.main.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Film létrehozásához szükséges DTO")
public class NMovieRequest {

    @NotBlank(message = "A cím megadása kötelező!")
    @Schema(description = "A film címe", example = "Mátrix")
    private String title;

    @Min(1888)
    @Schema(description = "Megjelenés éve (nem lehet korábbi, mint az első film éve)", example = "1999")
    private int releaseYear;

    @Positive
    @Schema(description = "Filmhossz percekben (pozitív szám)", example = "136")
    private int runtimeMin;

    @NotBlank(message = "A PLOT megadása kötelező!")
    @Schema(description = "A film története / rövid leírás", 
            example = "Egy hacker rájön, hogy a világ, amelyben él, csak egy szimuláció.")
    private String plot;

    @NotBlank(message = "A Poster megadása kötelező!")
    @Size(max = 2048)
    @Schema(description = "Plakát elérési URL", example = "https://image.tmdb.org/t/p/matrix.jpg")
    private String posterUrl;
}


