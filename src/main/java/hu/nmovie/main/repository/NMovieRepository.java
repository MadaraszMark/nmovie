package hu.nmovie.main.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.nmovie.main.model.NMovie;

/**
 * Repository interfész a NMovie entitáshoz, az adatbázis műveletekért felel.
 * A Spring Data JPA biztosítja az alap műveletek implementációját, és itt további lekérdezési metódusok vannak definiálva a filmek kereséséhez.
 */

public interface NMovieRepository extends JpaRepository<NMovie, Long>{ // Alap crud műveletek
	Optional<NMovie> findById(Long id);
	
	Page<NMovie> findAllByIsDeletedFalse(Pageable pageable);
	Page<NMovie> findAllByTitleContainingIgnoreCaseAndIsDeletedFalse(String title, Pageable pageable);
	Page<NMovie> findAllByReleaseYearAndIsDeletedFalse(int releaseYear, Pageable pageable);
	Optional<NMovie> findTopByIsDeletedFalseOrderByReleaseYearAsc();
	
	@Query("select avg(m.runtimeMin) from NMovie m where m.isDeleted = false")
	Double findAverageRuntime();
	
	@Modifying
	@Query("UPDATE NMovie m SET m.isDeleted = true WHERE m.id = :id")
	int softDeleteById(@Param("id") Long id);
	
}
