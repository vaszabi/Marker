package hu.wup.wuppadavans.service.impl;

import hu.wup.wuppadavans.entity.MarkerEntity;
import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.repository.MarkerRepository;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {

    private MarkerRepository markerRepository;
    private List<Marker> markers;


    public MarkerServiceImpl() {
        this.markers = new ArrayList();
    }


    @Override
    public ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId) {
        List<Marker> temp = new ArrayList<Marker>();
        for (Marker marker : temp) {
            if (!markerId.equals(marker.getId())) {
                temp.add(marker);
            }
        }
        markers = temp;
        return (ResponseEntity<Void>) markers;
    }


    @Override
    public ResponseEntity<List<Marker>> loadAllmarker() {
        List<Marker> markerElements = new ArrayList();
        List<MarkerEntity> markerEntities = markerRepository.findAll();
        for (MarkerEntity entity : markerEntities) {
            Marker marker = new Marker();
            marker.setName(entity.getName());
            marker.setId(entity.getId());
            marker.setAddress(entity.getAddress());
            marker.setDescription(entity.getDescription());
            marker.setIsOpen(entity.getOpen());
            marker.setPhones(entity.getPhones());
            marker.setHasPharmacy(entity.getHasPharmacy());
            marker.setIsPharmacyOpen(entity.getPharmacyOpen());
            marker.setIsDuty(entity.getDuty());
            marker.setLatitude(entity.getLatitude());
            marker.setLongitude(entity.getLongitude());
            marker.setFacebookUri(entity.getFacebookUri());
            marker.setImageUri(entity.getImageUri());
            marker.setType(entity.getType());
            marker.setWebUri(entity.getWebUri());


            markerElements.add(marker);
        }
        return (ResponseEntity<List<Marker>>) markerElements;
    }

    @Override
    public ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId) {

        for (Marker marker : markers) {
            if (markerId.equals(marker.getId())) {
                markerRepository.findOne(markerId);
                return (ResponseEntity<Marker>) markers;
            }
        }

        return null;
    }


    @Override
    public ResponseEntity<Marker> register(@RequestBody Marker marker) {
        MarkerEntity markerEntity = new MarkerEntity(marker.getName(), marker.getAddress(), marker.getDescription(), marker.getId(), marker.getIsOpen(), marker.getHasPharmacy(), marker.getIsPharmacyOpen(), marker.getIsDuty(), marker.getType(), marker.getWebUri(), marker.getPhones(), marker.getFacebookUri(), marker.getImageUri(), marker.getLatitude(), marker.getLongitude());
        MarkerEntity entity = markerRepository.save(markerEntity);

        Marker savedMarker = new Marker();
        savedMarker.setId(markerEntity.getId());
        return ResponseEntity.ok(savedMarker);
    }

    @Override
    public ResponseEntity<Void> updatemarker(@RequestBody Marker updatedMarker, @PathVariable("markerId") Long markerId) {
        for (Marker marker : markers) {
            if (markerId.equals(marker.getId())) {
                marker.setName(updatedMarker.getName());
                marker.setId(updatedMarker.getId());
                marker.setAddress(updatedMarker.getAddress());
                marker.setDescription(updatedMarker.getDescription());
                marker.setIsOpen(updatedMarker.getIsOpen());
                marker.setPhones(updatedMarker.getPhones());
                marker.setHasPharmacy(updatedMarker.getHasPharmacy());
                marker.setIsPharmacyOpen(updatedMarker.getIsPharmacyOpen());
                marker.setIsDuty(updatedMarker.getIsDuty());
                marker.setLatitude(updatedMarker.getLatitude());
                marker.setLongitude(updatedMarker.getLongitude());
                marker.setFacebookUri(updatedMarker.getFacebookUri());
                marker.setImageUri(updatedMarker.getImageUri());
                marker.setType(updatedMarker.getType());
                marker.setWebUri(updatedMarker.getWebUri());


            }
        }
        return ResponseEntity.ok().build();
    }
}