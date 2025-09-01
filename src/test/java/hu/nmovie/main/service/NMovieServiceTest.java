package hu.nmovie.main.service;

import hu.nmovie.main.exception.NMovieNotFoundException;
import hu.nmovie.main.model.NMovie;
import hu.nmovie.main.repository.NMovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Mockito
class NMovieServiceTest {

    @Mock	// Hamis példány, elszigetelten tudom tesztelni a service logikát, adatbázis nélkül
    private NMovieRepository nMovieRepository; // mock objektum

    @InjectMocks	// Létrehozza a tesztelt osztályt, és belerakja a mock-okat, hogy ne kelljen valódi függőségeket használnunk.
    private NMovieService nMovieService; // a service, amit tesztelünk

    @Test
    void testGetMovieById_Found() {
        NMovie movie = NMovie.builder()
        		.id(1L)
        		.title("Mátrix")
        		.releaseYear(1999)
        		.runtimeMin(136)
        		.plot("Hacker felfedezi a Mátrixot")
        		.posterUrl("matrix.jpg")
        		.createdAt(LocalDateTime.now())
        		.build();

        when(nMovieRepository.findById(1L)).thenReturn(Optional.of(movie));

        NMovie result = nMovieService.getMovieById(1L);

        assertNotNull(result);
        assertEquals("Mátrix", result.getTitle());
        verify(nMovieRepository, times(1)).findById(1L); // ellenőrizzük, hogy hívtuk
    }

    @Test
    void testGetMovieById_NotFound() {
        when(nMovieRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NMovieNotFoundException.class, () -> nMovieService.getMovieById(99L));
        verify(nMovieRepository, times(1)).findById(99L);
    }
}

