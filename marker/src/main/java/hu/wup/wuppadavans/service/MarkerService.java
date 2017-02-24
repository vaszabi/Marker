package hu.wup.wuppadavans.service;

import hu.wup.wuppadavans.dto.MarkerDto;
import hu.wup.wuppadavans.model.Marker;

import java.util.List;

public interface MarkerService {

    void deletemarkerById(Long markerDtoId);

    List<MarkerDto> loadAllmarker();

    MarkerDto loadmarkerById(Long markerDtoId);

    MarkerDto register(MarkerDto markerDto);

    void updatemarker(MarkerDto updatedMarkerDto, Long markerDtoId);

    MarkerDto closestMarker(MarkerDto markerDto);
}
