package hu.wup.wuppadavans.service;

import com.google.maps.model.DirectionsResult;
import hu.wup.wuppadavans.dto.MarkerDto;

import java.util.List;

public interface MarkerService {

    void deletemarkerById(Long markerDtoId);

    List<MarkerDto> loadAllmarker();

    MarkerDto loadmarkerById(Long markerDtoId);

    MarkerDto register(MarkerDto markerDto);

    void updatemarker(MarkerDto updatedMarkerDto, Long markerDtoId);

    MarkerDto closestMarker(MarkerDto markerDto);

    DirectionsResult closestMarkerDriving(MarkerDto markerDto);
}
