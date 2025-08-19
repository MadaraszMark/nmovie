package hu.nmovie.main.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

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
	
	public NMovieResponse() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
