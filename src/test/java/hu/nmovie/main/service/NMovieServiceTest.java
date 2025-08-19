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

@ExtendWith(MockitoExtension.class) // Mockito-t engedélyezzük
class NMovieServiceTest {

    @Mock
    private NMovieRepository nMovieRepository; // mock objektum

    @InjectMocks
    private NMovieService nMovieService; // a service, amit tesztelünk

    @Test
    void testGetMovieById_Found() {
        NMovie movie = new NMovie();
        movie.setId(1L);
        movie.setTitle("Mátrix");
        movie.setReleaseYear(1999);
        movie.setRuntimeMin(136);
        movie.setPlot("Hacker felfedezi a Mátrixot");
        movie.setPosterUrl("matrix.jpg");
        movie.setCreatedAt(LocalDateTime.now());

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

