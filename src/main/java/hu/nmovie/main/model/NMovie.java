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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * JPA entitás osztály, amely egy filmet reprezentál az adatbázisban.
 * Lombok annotációk (@Getter, @Setter, @Builder, stb.) biztosítják a getter/setter és egyéb boilerplate kódot.
 * Az audit mezők (@CreatedDate, @LastModifiedDate) automatikusan beállítódnak az entitás létrehozásakor és módosításakor.
 */

@Entity
@Table(name = "movie")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA-nak kell
@AllArgsConstructor
@ToString(exclude = "plot")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class NMovie {
	
	//POJO
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
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

}
