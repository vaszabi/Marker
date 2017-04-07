package hu.wup.wuppadavans.controller.impl;

import com.google.maps.model.DirectionsResult;
import hu.wup.wuppadavans.controller.MarkerApi;
import hu.wup.wuppadavans.dto.MarkerDto;
import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MarkerController implements MarkerApi {

    @Autowired
    private MarkerService markerService;

    protected MarkerController() {}

    @Autowired
    public void setMarkerService(MarkerService markerService) {
        this.markerService = markerService;
    }

    @Override
    public ResponseEntity<?> deletemarkerById(@PathVariable Long markerId) {

        markerService.deletemarkerById(markerId);

        return new ResponseEntity<Marker>(HttpStatus.NO_CONTENT);
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
        if(markerList.isEmpty()){
            return new ResponseEntity<List<Marker>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Marker>>(markerList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Marker> loadmarkerById(@PathVariable Long markerId) {

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

        return new ResponseEntity<Marker>(marker, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> register(@RequestBody Marker marker, UriComponentsBuilder ucBuilder) {
        MarkerDto markerDto = new MarkerDto();

        markerDto.setName(marker.getName());
        markerDto.setId(marker.getId());
        markerDto.setAddress(marker.getAddress());
        markerDto.setDescription(marker.getDescription());
        markerDto.setOpen(marker.getIsOpen());
        markerDto.setPhones(marker.getPhones());
        markerDto.setHasPharmacy(marker.getHasPharmacy());
        markerDto.setPharmacyOpen(marker.getIsPharmacyOpen());
        markerDto.setDuty(marker.getIsDuty());
        markerDto.setLatitude(marker.getLatitude());
        markerDto.setLongitude(marker.getLongitude());
        markerDto.setFacebookUri(marker.getFacebookUri());
        markerDto.setImageUri(marker.getImageUri());
        markerDto.setType(marker.getType());
        markerDto.setWebUri(marker.getWebUri());

        markerService.register(markerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/marker/{markerId}").buildAndExpand(markerDto.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updatemarker(@RequestBody Marker updatedMarker, @PathVariable Long markerId) {

        MarkerDto markerDto = markerService.loadmarkerById(markerId);

        if(markerDto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        markerDto.setName(updatedMarker.getName());
        //markerDto.setId(updatedMarker.getId());
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


        markerService.updatemarker(markerDto, markerDto.getId());


        return new ResponseEntity<Marker>(updatedMarker, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Marker> closestMarker(@RequestBody Marker marker) {

        MarkerDto markerDto = new MarkerDto();
        markerDto.setLatitude(marker.getLatitude());
        markerDto.setLongitude(marker.getLongitude());

        MarkerDto closestMarkerDto = markerService.closestMarker(markerDto);
        Marker closestMarker = new Marker();

        closestMarker.setName(closestMarkerDto.getName());
        closestMarker.setId(closestMarkerDto.getId());
        closestMarker.setAddress(closestMarkerDto.getAddress());
        closestMarker.setDescription(closestMarkerDto.getDescription());
        closestMarker.setIsOpen(closestMarkerDto.getOpen());
        closestMarker.setPhones(closestMarkerDto.getPhones());
        closestMarker.setHasPharmacy(closestMarkerDto.getHasPharmacy());
        closestMarker.setIsPharmacyOpen(closestMarkerDto.getPharmacyOpen());
        closestMarker.setIsDuty(closestMarkerDto.getDuty());
        closestMarker.setLatitude(closestMarkerDto.getLatitude());
        closestMarker.setLongitude(closestMarkerDto.getLongitude());
        closestMarker.setFacebookUri(closestMarkerDto.getFacebookUri());
        closestMarker.setImageUri(closestMarkerDto.getImageUri());
        closestMarker.setType(closestMarkerDto.getType());
        closestMarker.setWebUri(closestMarkerDto.getWebUri());

        return new ResponseEntity<Marker>(closestMarker, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DirectionsResult> closestMarkerDriving(@RequestBody Marker marker) {

        MarkerDto markerDto = new MarkerDto();
        markerDto.setLatitude(marker.getLatitude());
        markerDto.setLongitude(marker.getLongitude());

        DirectionsResult direction = markerService.closestMarkerDriving(markerDto);


        return new ResponseEntity<DirectionsResult>(direction, HttpStatus.OK);
    }
}