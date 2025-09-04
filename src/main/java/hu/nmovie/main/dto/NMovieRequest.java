package hu.nmovie.main.dto;

import org.hibernate.validator.constraints.URL;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

// DTO osztály, amely egy új film létrehozásához vagy frissítéséhez szükséges adatokat tartalmaz.
// A kliens által küldött adatok szállítására szolgál (pl. cím, év, hossz, cselekmény, poszter URL).

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Film létrehozásához szükséges DTO")
public class NMovieRequest {

    @NotBlank(message = "A cím megadása kötelező!")
    @Size(max = 200, message = "A cím legfeljebb 200 karakter lehet.")
    @Schema(description = "A film címe", example = "Mátrix")
    private String title;

    @Min(1888)
    @Schema(description = "Megjelenés éve (nem lehet korábbi, mint az első film éve)", example = "1999")
    private int releaseYear;

    @Positive
    @Min(value = 1, message = "A filmhossz legyen legalább 1 perc.")
    @Max(value = 600, message = "A filmhossz legfeljebb 600 perc lehet.")
    @Schema(description = "Filmhossz percekben (pozitív szám)", example = "136")
    private int runtimeMin;

    @NotBlank(message = "A PLOT megadása kötelező!")
    @Size(min = 10, message = "A leírás legyen legalább 10 karakter.")
    @Schema(description = "A film története / rövid leírás", example = "Egy hacker rájön, hogy a világ, amelyben él, csak egy szimuláció.")
    private String plot;

    @NotBlank(message = "A Poster megadása kötelező!")
    @Size(max = 2048, message = "Az URL legfeljebb 2048 karakter lehet.")
    @URL(message = "A poszter URL nem érvényes.")
    @Schema(description = "Plakát elérési URL", example = "https://image.tmdb.org/t/p/matrix.jpg")
    private String posterUrl;
}


