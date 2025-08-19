package hu.nmovie.main.mapper;

import org.springframework.stereotype.Component;

import hu.nmovie.main.dto.NMovieRequest;
import hu.nmovie.main.dto.NMovieResponse;
import hu.nmovie.main.model.NMovie;

@Component
public class NMovieMapper {

    public NMovie toEntity(NMovieRequest dto) {
        return NMovie.builder()
                .title(dto.getTitle())
                .releaseYear(dto.getReleaseYear())
                .runtimeMin(dto.getRuntimeMin())
                .plot(dto.getPlot())
                .posterUrl(dto.getPosterUrl())
                .build();
    }

    public NMovieResponse toResponse(NMovie entity) {
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


