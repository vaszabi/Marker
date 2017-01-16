package hu.wup.wuppadavans.service.impl;

import hu.wup.wuppadavans.entity.MarkerEntity;
import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.service.MarkerService;
import hu.wup.wuppadavans.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


public class MarkerServiceImpl implements MarkerService {

    private MarkerRepository markerRepository;
    private List<Marker> markers;

    @Autowired
    public void setUserRepository(MarkerRepository markerRepository) {
        this.markerRepository = markerRepository;
    }

    public MarkerServiceImpl() {
        this.markers = new ArrayList();
    }


    @Override
    public ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId) {
        List<Marker> temp = new ArrayList<Marker>();
        for (Marker marker : temp) {
            if (!id.equals(marker.getId())) {
                temp.add(marker);
            }
        }
        markers = temp;
        return (ResponseEntity<Void>) markers;
    }


    @Override
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
        MarkerEntity markerEntity = new MarkerEntity(marker.getName(), marker.getAddress(), marker.getDescription(), marker.getId(), marker.getOpeningTime(), marker.getIsOpen(), marker.getHasPharmacy(), marker.getPharmacyOpeningTime(), marker.getIsPharmacyOpen(), marker.getIsDuty(), marker.getType(), marker.getWebUri(), marker.getPhones(), marker.getFacebookUri(), marker.getImageUri(), marker.getLatitude(), marker.getLongitude());
        markerRepository.save((Iterable<Marker>) markerEntity);
        return (ResponseEntity<Marker>) markerRepository;
    }

    public ResponseEntity<Void> updatemarker(@RequestBody Marker marker) {
        return null;
    }
}