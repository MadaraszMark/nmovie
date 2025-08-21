package hu.nmovie.main.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

// DTO osztály, amely a klienseknek visszaküldendő film adatokat tartalmazza.
// A film összes fontos mezőjét tartalmazza (pl. azonosító, cím, év, hossz, stb.), beleértve a metaadatokat (létrehozás és módosítás ideje).

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "A film adatait visszaadó DTO")
public class NMovieResponse {
	
    @Schema(description = "A film azonosítója", example = "42")
    private Long id;

    @Schema(description = "A film címe", example = "Mátrix")
    private String title;

    @Schema(description = "Megjelenés éve", example = "1999")
    private int releaseYear;

    @Schema(description = "Filmhossz percekben", example = "136")
    private int runtimeMin;

    @Schema(description = "A film története / rövid leírás")
    private String plot;

    @Schema(description = "Plakát elérési URL", example = "https://image.tmdb.org/t/p/matrix.jpg")
    private String posterUrl;

    @Schema(description = "Létrehozás időpontja", example = "2025-08-18T10:15:30")
    private LocalDateTime createdAt;

    @Schema(description = "Utolsó módosítás időpontja", example = "2025-08-18T12:00:00")
    private LocalDateTime updatedAt;
}

