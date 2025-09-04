package hu.nmovie.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.nmovie.main.dto.NMovieRequest;
import hu.nmovie.main.dto.NMovieResponse;
import hu.nmovie.main.dto.NMovieUpdateRequest;
import hu.nmovie.main.mapper.NMovieMapper;
import hu.nmovie.main.model.NMovie;
import hu.nmovie.main.service.NMovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * REST vezérlő (controller) a film erőforrások kezelésére.
 * Definiálja a végpontokat a filmek lekérdezéséhez, létrehozásához, kereséséhez és logikai törléséhez.
 * A kéréseket a service réteghez továbbítja, és az eredményeket NMovieResponse DTO-kká alakítva küldi vissza.
 */

@RestController
@RequestMapping("/movies")
@Tag(name = "NMovies API", description = "Egyszerű filmes REST API")
public class NMovieController {
	
	private final NMovieService nMovieService;
	private final NMovieMapper mapper;
	
	@Autowired
	public NMovieController(NMovieService nMovieService, NMovieMapper mapper) { 	// Az @Autowired megmondja a Springnek, hogy a konstruktor paramétereit automatikusan adja be a Spring contextből. Konstruktor injekció.
		this.nMovieService = nMovieService;
		this.mapper = mapper;
	}
	
	@GetMapping
	@Operation(summary = "Összes film lekérése", description = "Visszaadja az összes elérhető Filmet.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sikeres lekérés"),
        @ApiResponse(responseCode = "500", description = "Szerverhiba")
    })
	public Page<NMovieResponse> getAllMovies(Pageable pageable){
		return nMovieService.getAllMovies(pageable).map(mapper::toResponse);
	}
	
	@PostMapping
	@Operation(summary = "Új film létrehozása")
	public NMovieResponse addMovie(@RequestBody @Valid NMovieRequest request) {
	    NMovie entity = mapper.toEntity(request);
	    NMovie saved = nMovieService.addMovie(entity);
	    return mapper.toResponse(saved);
	}
	
	@GetMapping("/by-id/{id}")
	public NMovieResponse getMovieById(@PathVariable Long id){
		return mapper.toResponse(nMovieService.getMovieById(id));
	}
	
	@GetMapping("/by-title/{title}")
	public Page<NMovieResponse> getMovieByTitleIgnoreCase(@PathVariable String title, Pageable pageable){
		return nMovieService.getByTitleIgnoreCase(title, pageable).map(mapper::toResponse);
	}
	
	@GetMapping("/get-releaseDate/{releaseDate}")
	public Page<NMovieResponse> getMovieByReleaseDate(@PathVariable int releaseDate, Pageable pageable){
		return nMovieService.getByReleaseYear(releaseDate, pageable).map(mapper::toResponse);
	}
	
	@GetMapping("/oldest")
	public NMovieResponse getMovieByOldest() {
		return mapper.toResponse(nMovieService.getOldest());
	}
	
	@GetMapping("/average-runtime")
	public ResponseEntity<Double> getAverageRuntime(){
		return ResponseEntity.ok(nMovieService.getAverageRuntime());
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Film frissítése")
	public NMovieResponse updateMovie(@PathVariable Long id, @RequestBody @Valid NMovieUpdateRequest request) {
	    NMovie updated = nMovieService.updateMovie(id, request);
	    return mapper.toResponse(updated);
	}

	
	@DeleteMapping("/{id}")
	@Operation(summary = "Film törlése (soft delete)")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    nMovieService.deleteMovie(id);
	    return ResponseEntity.noContent().build(); // REST konvenció
	}

}
