package hu.wup.wuppadavans.service.impl;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.Unit;
import hu.wup.wuppadavans.dto.MarkerDto;
import hu.wup.wuppadavans.entity.MarkerEntity;
import hu.wup.wuppadavans.repository.MarkerRepository;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private MarkerRepository markerRepository;

    protected MarkerServiceImpl() {
    }


    @Override
    public void deletemarkerById(Long markerDtoId) {

        markerRepository.delete(markerDtoId);
    }


    @Override
    public List<MarkerDto> loadAllmarker() {
        List<MarkerDto> markerElements = new ArrayList<>();
        List<MarkerEntity> markerEntities = markerRepository.findAll();
        for (MarkerEntity entity : markerEntities) {
            MarkerDto markerDto = new MarkerDto();
            markerDto.setName(entity.getName());
            markerDto.setId(entity.getId());
            markerDto.setAddress(entity.getAddress());
            markerDto.setDescription(entity.getDescription());
            markerDto.setOpen(entity.getOpen());
            markerDto.setPhones(entity.getPhones());
            markerDto.setHasPharmacy(entity.getHasPharmacy());
            markerDto.setPharmacyOpen(entity.getPharmacyOpen());
            markerDto.setDuty(entity.getDuty());
            markerDto.setLatitude(entity.getLatitude());
            markerDto.setLongitude(entity.getLongitude());
            markerDto.setFacebookUri(entity.getFacebookUri());
            markerDto.setImageUri(entity.getImageUri());
            markerDto.setType(entity.getType());
            markerDto.setWebUri(entity.getWebUri());


            markerElements.add(markerDto);
        }
        return markerElements;
    }

    @Override
    public MarkerDto loadmarkerById(Long markerDtoId) {

        MarkerEntity entity = markerRepository.findOne(markerDtoId);
        MarkerDto markerDto = new MarkerDto();

        markerDto.setName(entity.getName());
        markerDto.setId(entity.getId());
        markerDto.setAddress(entity.getAddress());
        markerDto.setDescription(entity.getDescription());
        markerDto.setOpen(entity.getOpen());
        markerDto.setPhones(entity.getPhones());
        markerDto.setHasPharmacy(entity.getHasPharmacy());
        markerDto.setPharmacyOpen(entity.getPharmacyOpen());
        markerDto.setDuty(entity.getDuty());
        markerDto.setLatitude(entity.getLatitude());
        markerDto.setLongitude(entity.getLongitude());
        markerDto.setFacebookUri(entity.getFacebookUri());
        markerDto.setImageUri(entity.getImageUri());
        markerDto.setType(entity.getType());
        markerDto.setWebUri(entity.getWebUri());


        return markerDto;

    }


    @Override
    public MarkerDto register(MarkerDto markerDto) {
        MarkerEntity markerEntity = new MarkerEntity();
        markerEntity.setName(markerDto.getName());
        markerEntity.setId(markerDto.getId());
        markerEntity.setAddress(markerDto.getAddress());
        markerEntity.setDescription(markerDto.getDescription());
        markerEntity.setOpen(markerDto.getOpen());
        markerEntity.setPhones(markerDto.getPhones());
        markerEntity.setHasPharmacy(markerDto.getHasPharmacy());
        markerEntity.setPharmacyOpen(markerDto.getPharmacyOpen());
        markerEntity.setDuty(markerDto.getDuty());
        markerEntity.setLatitude(markerDto.getLatitude());
        markerEntity.setLongitude(markerDto.getLongitude());
        markerEntity.setFacebookUri(markerDto.getFacebookUri());
        markerEntity.setImageUri(markerDto.getImageUri());
        markerEntity.setType(markerDto.getType());
        markerEntity.setWebUri(markerDto.getWebUri());

        MarkerEntity savedData = markerRepository.save(markerEntity);

        MarkerDto savedMarkerDto = new MarkerDto();
        savedMarkerDto.setName(savedData.getName());
        savedMarkerDto.setId(savedData.getId());
        savedMarkerDto.setAddress(savedData.getAddress());
        savedMarkerDto.setDescription(savedData.getDescription());
        savedMarkerDto.setOpen(savedData.getOpen());
        savedMarkerDto.setPhones(savedData.getPhones());
        savedMarkerDto.setHasPharmacy(savedData.getHasPharmacy());
        savedMarkerDto.setPharmacyOpen(savedData.getPharmacyOpen());
        savedMarkerDto.setDuty(savedData.getDuty());
        savedMarkerDto.setLatitude(savedData.getLatitude());
        savedMarkerDto.setLongitude(savedData.getLongitude());
        savedMarkerDto.setFacebookUri(savedData.getFacebookUri());
        savedMarkerDto.setImageUri(savedData.getImageUri());
        savedMarkerDto.setType(savedData.getType());
        savedMarkerDto.setWebUri(savedData.getWebUri());


        return savedMarkerDto;
    }

    @Override
    public void updatemarker(MarkerDto updatedMarkerDto, Long markerDtoId) {
        MarkerEntity entity = markerRepository.findOne(markerDtoId);

        entity.setName(updatedMarkerDto.getName());
        //entity.setId(updatedMarkerDto.getId());
        entity.setAddress(updatedMarkerDto.getAddress());
        entity.setDescription(updatedMarkerDto.getDescription());
        entity.setOpen(updatedMarkerDto.getOpen());
        entity.setPhones(updatedMarkerDto.getPhones());
        entity.setHasPharmacy(updatedMarkerDto.getHasPharmacy());
        entity.setPharmacyOpen(updatedMarkerDto.getPharmacyOpen());
        entity.setDuty(updatedMarkerDto.getDuty());
        entity.setLatitude(updatedMarkerDto.getLatitude());
        entity.setLongitude(updatedMarkerDto.getLongitude());
        entity.setFacebookUri(updatedMarkerDto.getFacebookUri());
        entity.setImageUri(updatedMarkerDto.getImageUri());
        entity.setType(updatedMarkerDto.getType());
        entity.setWebUri(updatedMarkerDto.getWebUri());

        markerRepository.save(entity);
    }

    @Override
    public MarkerDto closestMarker(MarkerDto markerDto) {

        double diff;
        double mindDiff = Double.MAX_VALUE;
        MarkerDto closestMarkerDto = new MarkerDto();
        List<MarkerEntity> markerEntities = markerRepository.findAll();
        for (MarkerEntity entity : markerEntities) {
            diff = distance(markerDto.getLatitude(), markerDto.getLongitude(), entity.getLatitude(), entity.getLongitude());

            if (diff < mindDiff) {
                mindDiff = diff;

                closestMarkerDto.setName(entity.getName());
                closestMarkerDto.setId(entity.getId());
                closestMarkerDto.setAddress(entity.getAddress());
                closestMarkerDto.setDescription(entity.getDescription());
                closestMarkerDto.setOpen(entity.getOpen());
                closestMarkerDto.setPhones(entity.getPhones());
                closestMarkerDto.setHasPharmacy(entity.getHasPharmacy());
                closestMarkerDto.setPharmacyOpen(entity.getPharmacyOpen());
                closestMarkerDto.setDuty(entity.getDuty());
                closestMarkerDto.setLatitude(entity.getLatitude());
                closestMarkerDto.setLongitude(entity.getLongitude());
                closestMarkerDto.setFacebookUri(entity.getFacebookUri());
                closestMarkerDto.setImageUri(entity.getImageUri());
                closestMarkerDto.setType(entity.getType());
                closestMarkerDto.setWebUri(entity.getWebUri());
            }


        }


        return closestMarkerDto;
    }

    @Override
    public DirectionsResult closestMarkerDriving(MarkerDto markerDto) {

        GeoApiContext geoApiContext = new GeoApiContext().setApiKey("API_KEY");
        MarkerDto closestMarkerDto = closestMarker(markerDto);

        DirectionsResult result = new DirectionsResult();

        try {

            DirectionsResult directions = DirectionsApi.newRequest(geoApiContext)
                    .origin(markerDto.toString())
                    .destination(closestMarkerDto.toString())
                    .units(Unit.METRIC)
                    .await();

            result = directions;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(lat1 * Math.PI / 180.0) * Math.sin(lat2 * Math.PI / 180.0) + Math.cos(lat1 * Math.PI / 180.0) * Math.cos(lat2 * Math.PI / 180.0) * Math.cos(theta * Math.PI / 180.0);
        dist = Math.acos(dist);
        dist = dist * 180 / Math.PI;
        //KM-ben való megadás miatt kellett még az 1.60...-val megszorozni
        dist = dist * 60 * 1.1515 * 1.609344;

        return dist;
    }

}
