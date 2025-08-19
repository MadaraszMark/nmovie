package hu.nmovie.main.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "movie")
@EntityListeners(AuditingEntityListener.class)
public class NMovie {
	
	//POJO
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "A film címe kötelező!")
	@Column(nullable = false, length = 200)
	private String title;
	
	@Column(name = "release_year", nullable = false)
	private int releaseYear;
	
	@Positive
	@Column(name = "runtime_min", nullable = false)
	private int runtimeMin;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String plot;
	
	@Size(max = 2048)
	@Column(name = "poster_url")
	private String posterUrl;
	
	@Column(name = "is_deleted")
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private boolean isDeleted;
	
	@CreatedDate
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public NMovie(Long id, String title, int releaseYear, int runtimeMin, String plot,
            String posterUrl, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
	this.id = id;
  	this.title = title;
  	this.releaseYear = releaseYear;
  	this.runtimeMin = runtimeMin;
  	this.plot = plot;
  	this.posterUrl = posterUrl;
  	this.isDeleted = isDeleted;
  	this.createdAt = createdAt;
  	this.updatedAt = updatedAt;
	}

	public NMovie(String title, int releaseYear, int runtimeMin, String plot,
            String posterUrl, boolean isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
	this.title = title;
  	this.releaseYear = releaseYear;
  	this.runtimeMin = runtimeMin;
  	this.plot = plot;
  	this.posterUrl = posterUrl;
  	this.isDeleted = isDeleted;
  	this.createdAt = createdAt;
  	this.updatedAt = updatedAt;
	}
	
	public NMovie() {
		// Hibernate
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	@Override
	public String toString() {
		return "NMovie [id=" + id + ", title=" + title + ", releaseYear=" + releaseYear + ", runtimeMin=" + runtimeMin
				+ ", plot=" + plot + ", posterUrl=" + posterUrl + ", isDeleted=" + isDeleted + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
