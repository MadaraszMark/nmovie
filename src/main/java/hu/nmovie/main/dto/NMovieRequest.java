package hu.nmovie.main.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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
    @Schema(description = "A film története / rövid leírás", example = "Egy hacker rájön, hogy a világ, amelyben él, csak egy szimuláció.")
    private String plot;

	@NotBlank(message = "A Poster megadása kötelező!")
    @Schema(description = "Plakát elérési URL", example = "https://image.tmdb.org/t/p/matrix.jpg")
    private String posterUrl;

    public NMovieRequest() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRuntimeMin() {
        return runtimeMin;
    }
    public void setRuntimeMin(int runtimeMin) {
        this.runtimeMin = runtimeMin;
    }

    public String getPlot() {
        return plot;
    }
    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}

