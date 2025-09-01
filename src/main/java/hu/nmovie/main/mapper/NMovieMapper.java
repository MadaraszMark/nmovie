package hu.nmovie.main.mapper;

import org.springframework.stereotype.Component;

import hu.nmovie.main.dto.NMovieRequest;
import hu.nmovie.main.dto.NMovieResponse;
import hu.nmovie.main.model.NMovie;

/**
 * Mapper osztály a NMovie entitás és a kapcsolódó DTO-k közötti átalakításra.
 * Feladata a bejövő adatok (NMovieRequest) entitássá alakítása, valamint az entitás adatainak átvezetése a kimenő DTO-ba (NMovieResponse).
 */

@Component			// A @Component regisztrálja a NMovieMapper-t a Spring context-ben, így más osztályokba be tudjuk injektálni.
public class NMovieMapper {

    public NMovie toEntity(NMovieRequest dto) { // A kapott NMovieRequest DTO alapján létrehoz egy új NMovie entitást.
        return NMovie.builder()
                .title(dto.getTitle())
                .releaseYear(dto.getReleaseYear())
                .runtimeMin(dto.getRuntimeMin())
                .plot(dto.getPlot())
                .posterUrl(dto.getPosterUrl())
                .build();
    }

    public NMovieResponse toResponse(NMovie entity) { // A kapott NMovie entitás alapján létrehoz egy NMovieResponse DTO-t.
        NMovieResponse dto = new NMovieResponse();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setRuntimeMin(entity.getRuntimeMin());
        dto.setPlot(entity.getPlot());
        dto.setPosterUrl(entity.getPosterUrl());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}


