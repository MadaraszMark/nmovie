package hu.nmovie.main.mapper;

import hu.nmovie.main.dto.NMovieRequest;
import hu.nmovie.main.dto.NMovieResponse;
import hu.nmovie.main.model.NMovie;
import org.springframework.stereotype.Component;

@Component
public class NMovieMapper {

    public NMovie toEntity(NMovieRequest dto) {
        NMovie m = new NMovie();
        m.setTitle(dto.getTitle());
        m.setReleaseYear(dto.getReleaseYear());
        m.setRuntimeMin(dto.getRuntimeMin());
        m.setPlot(dto.getPlot());
        m.setPosterUrl(dto.getPosterUrl());
        return m;
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

