package hu.nmovie.main.mapper;

import hu.nmovie.main.dto.NMovieRequest;
import hu.nmovie.main.dto.NMovieResponse;
import hu.nmovie.main.model.NMovie;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NMovieMapperTest {

    private final NMovieMapper mapper = new NMovieMapper();

    @Test
    void testToEntity() {
        NMovieRequest request = new NMovieRequest();
        request.setTitle("Mátrix");
        request.setReleaseYear(1999);
        request.setRuntimeMin(136);
        request.setPlot("Egy hacker rájön, hogy a világ csak szimuláció.");
        request.setPosterUrl("https://image.tmdb.org/t/p/matrix.jpg");

        NMovie entity = mapper.toEntity(request);

        assertNotNull(entity);
        assertEquals("Mátrix", entity.getTitle());
        assertEquals(1999, entity.getReleaseYear());
        assertEquals(136, entity.getRuntimeMin());
        assertEquals("Egy hacker rájön, hogy a világ csak szimuláció.", entity.getPlot());
        assertEquals("https://image.tmdb.org/t/p/matrix.jpg", entity.getPosterUrl());
    }

    @Test
    void testToResponse() {
        NMovie entity = new NMovie();
        entity.setId(1L);
        entity.setTitle("Inception");
        entity.setReleaseYear(2010);
        entity.setRuntimeMin(148);
        entity.setPlot("Egy profi tolvaj emberek álmaiból lop ötleteket.");
        entity.setPosterUrl("https://image.tmdb.org/t/p/inception.jpg");
        entity.setCreatedAt(LocalDateTime.of(2025, 1, 1, 12, 0));
        entity.setUpdatedAt(LocalDateTime.of(2025, 1, 2, 12, 0));

        NMovieResponse response = mapper.toResponse(entity);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Inception", response.getTitle());
        assertEquals(2010, response.getReleaseYear());
        assertEquals(148, response.getRuntimeMin());
        assertEquals("Egy profi tolvaj emberek álmaiból lop ötleteket.", response.getPlot());
        assertEquals("https://image.tmdb.org/t/p/inception.jpg", response.getPosterUrl());
        assertEquals(LocalDateTime.of(2025, 1, 1, 12, 0), response.getCreatedAt());
        assertEquals(LocalDateTime.of(2025, 1, 2, 12, 0), response.getUpdatedAt());
    }
}

