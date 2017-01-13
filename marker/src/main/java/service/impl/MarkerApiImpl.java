package service.impl;

import entity.MarkerEntity;
import model.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import repository.MarkerRepository;
import service.MarkerApi;

import java.util.ArrayList;
import java.util.List;


public class MarkerApiImpl implements MarkerApi {

    private MarkerRepository markerRepository;
    private List<Marker> markers;

    @Autowired
    public void setUserRepository(MarkerRepository userRepository) {
        this.markerRepository = userRepository;
    }

    public MarkerApiImpl() {
        this.markers = new ArrayList();
    }


    public ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId) {
        return null;
    }

    public ResponseEntity<List<Marker>> loadAllmarker() {
        List<Marker> markerElements = new ArrayList();
        List<Marker> markerEntities = markerRepository.findAll();
        for (Marker entity : markerEntities) {
            Marker marker = new Marker();
            marker.setName(entity.getName());
            marker.setId(entity.getId());
            marker.setAddress(entity.getAddress());
            marker.setDescription(entity.getDescription());
            marker.setOpeningTime(entity.getOpeningTime());
            marker.setIsOpen(entity.getIsOpen());
            marker.setPhones(entity.getPhones());
            marker.setHasPharmacy(entity.getHasPharmacy());
            marker.setIsPharmacyOpen(entity.getIsPharmacyOpen());
            marker.setPharmacyOpeningTime(entity.getPharmacyOpeningTime());
            marker.setIsDuty(entity.getIsDuty());
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

    public ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId) {

        for (Marker marker : markers) {
            if (markerId.equals(marker.getId())) {
                markerRepository.findOne(markerId);
                return (ResponseEntity<Marker>) markers;
            }
        }

        return null;
    }

    public ResponseEntity<Marker> register(@RequestBody Marker marker) {
        return null;
    }

    public ResponseEntity<Void> updatemarker(@RequestBody Marker marker) {
        return null;
    }
}