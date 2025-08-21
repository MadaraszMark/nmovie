package hu.nmovie.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hu.nmovie.main.exception.NMovieNotFoundException;
import hu.nmovie.main.model.NMovie;
import hu.nmovie.main.repository.NMovieRepository;
import jakarta.transaction.Transactional;

/**
 * A filmekkel kapcsolatos üzleti logikát megvalósító szolgáltatás (service) osztály.
 * Feladata a filmek lekérése, hozzáadása, keresése és logikai törlése a repository réteg segítségével.
 * Kivételkezelést is végez: például ha egy kért film nem létezik, NMovieNotFoundException-t dob.
 */

@Service
public class NMovieService {
	
	private final NMovieRepository nMovieRepository;
	
	public NMovieService(NMovieRepository nMovieRepository) {
		this.nMovieRepository = nMovieRepository;
	}
	
	public Page<NMovie> getAllMovies(Pageable pageable){
		return nMovieRepository.findAll(pageable);
	}
	
	@Transactional
	public NMovie addMovie(NMovie nMovie) {
		nMovie.setDeleted(false);
		return nMovieRepository.save(nMovie);
	}
	
	public NMovie getMovieById(Long id) {
		return nMovieRepository.findById(id).orElseThrow(() -> new NMovieNotFoundException(id));
	}
	
	public Page<NMovie> getByTitleIgnoreCase(String title, Pageable pageable){
		return nMovieRepository.findAllByTitleContainingIgnoreCaseAndIsDeletedFalse(title, pageable);
	}
	
	public Page<NMovie> getByReleaseYear(int releaseYear, Pageable pageable){
		return nMovieRepository.findAllByReleaseYearAndIsDeletedFalse(releaseYear, pageable);
	}
	
	public void deleteMovie(Long id) {
		int updated = nMovieRepository.softDeleteById(id);
		if(updated == 0) throw new NMovieNotFoundException(id);
	}

}
