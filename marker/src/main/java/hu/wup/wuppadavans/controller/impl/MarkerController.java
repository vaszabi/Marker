package hu.wup.wuppadavans.controller.impl;

import hu.wup.wuppadavans.controller.MarkerApi;
import hu.wup.wuppadavans.dto.MarkerDto;
import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.service.MarkerService;
import hu.wup.wuppadavans.service.impl.MarkerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MarkerController implements MarkerApi {

    private MarkerServiceImpl markerService = new MarkerServiceImpl();

    protected MarkerController() {

    }

    @Override
    public void setMarkerService(MarkerService markerService) {

    }

    @Override
    public ResponseEntity<Void> deletemarkerById(Long markerId) {

        markerService.deletemarkerById(markerId);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Marker>> loadAllmarker() {

        List<MarkerDto> markerDtoList = markerService.loadAllmarker();
        List<Marker> markerList = new ArrayList<>();

        for (MarkerDto markerDto : markerDtoList) {
            Marker marker = new Marker();

            marker.setName(markerDto.getName());
            marker.setId(markerDto.getId());
            marker.setAddress(markerDto.getAddress());
            marker.setDescription(markerDto.getDescription());
            marker.setIsOpen(markerDto.getOpen());
            marker.setPhones(markerDto.getPhones());
            marker.setHasPharmacy(markerDto.getHasPharmacy());
            marker.setIsPharmacyOpen(markerDto.getPharmacyOpen());
            marker.setIsDuty(markerDto.getDuty());
            marker.setLatitude(markerDto.getLatitude());
            marker.setLongitude(markerDto.getLongitude());
            marker.setFacebookUri(markerDto.getFacebookUri());
            marker.setImageUri(markerDto.getImageUri());
            marker.setType(markerDto.getType());
            marker.setWebUri(markerDto.getWebUri());

            markerList.add(marker);

        }

        return ResponseEntity.ok(markerList);
    }

    @Override
    public ResponseEntity<Marker> loadmarkerById(Long markerId) {

        MarkerDto markerDto = markerService.loadmarkerById(markerId);
        Marker marker = new Marker();

        marker.setName(markerDto.getName());
        marker.setId(markerDto.getId());
        marker.setAddress(markerDto.getAddress());
        marker.setDescription(markerDto.getDescription());
        marker.setIsOpen(markerDto.getOpen());
        marker.setPhones(markerDto.getPhones());
        marker.setHasPharmacy(markerDto.getHasPharmacy());
        marker.setIsPharmacyOpen(markerDto.getPharmacyOpen());
        marker.setIsDuty(markerDto.getDuty());
        marker.setLatitude(markerDto.getLatitude());
        marker.setLongitude(markerDto.getLongitude());
        marker.setFacebookUri(markerDto.getFacebookUri());
        marker.setImageUri(markerDto.getImageUri());
        marker.setType(markerDto.getType());
        marker.setWebUri(markerDto.getWebUri());

        return ResponseEntity.ok(marker);
    }

    @Override
    public ResponseEntity<Marker> register(Marker marker) {
        MarkerDto markerDto = new MarkerDto(marker.getName(), marker.getAddress(), marker.getDescription(), marker.getId(), marker.getIsOpen(), marker.getHasPharmacy(), marker.getIsPharmacyOpen(), marker.getIsDuty(), marker.getType(), marker.getWebUri(), marker.getPhones(), marker.getFacebookUri(), marker.getImageUri(), marker.getLatitude(), marker.getLongitude());

        Marker savedMarker = new Marker();
        savedMarker.setId(markerDto.getId());

        return ResponseEntity.ok(savedMarker);
    }

    @Override
    public ResponseEntity<Void> updatemarker(Marker updatedMarker, Long markerId) {

        List<MarkerDto> markerDtoList = markerService.loadAllmarker();


        for (MarkerDto markerDto : markerDtoList) {
            if (markerId.equals(markerDto.getId())) {

                markerDto.setName(updatedMarker.getName());
                markerDto.setId(updatedMarker.getId());
                markerDto.setAddress(updatedMarker.getAddress());
                markerDto.setDescription(updatedMarker.getDescription());
                markerDto.setOpen(updatedMarker.getIsOpen());
                markerDto.setPhones(updatedMarker.getPhones());
                markerDto.setHasPharmacy(updatedMarker.getHasPharmacy());
                markerDto.setPharmacyOpen(updatedMarker.getIsPharmacyOpen());
                markerDto.setDuty(updatedMarker.getIsDuty());
                markerDto.setLatitude(updatedMarker.getLatitude());
                markerDto.setLongitude(updatedMarker.getLongitude());
                markerDto.setFacebookUri(updatedMarker.getFacebookUri());
                markerDto.setImageUri(updatedMarker.getImageUri());
                markerDto.setType(updatedMarker.getType());
                markerDto.setWebUri(updatedMarker.getWebUri());

            }
        }
        return ResponseEntity.ok().build();
    }
}