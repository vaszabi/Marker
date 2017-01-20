package hu.wup.wuppadavans.service.impl;

import hu.wup.wuppadavans.dto.MarkerDto;
import hu.wup.wuppadavans.entity.MarkerEntity;
import hu.wup.wuppadavans.repository.MarkerRepository;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {

    private MarkerRepository markerRepository;
    //private List<MarkerDto> markerDtos;


    public MarkerServiceImpl() {
     //   this.markerDtos = new ArrayList<>();
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
        MarkerEntity markerEntity = new MarkerEntity(markerDto.getName(), markerDto.getAddress(), markerDto.getDescription(), markerDto.getId(), markerDto.getOpen(), markerDto.getHasPharmacy(), markerDto.getPharmacyOpen(), markerDto.getDuty(), markerDto.getType(), markerDto.getWebUri(), markerDto.getPhones(), markerDto.getFacebookUri(), markerDto.getImageUri(), markerDto.getLatitude(), markerDto.getLongitude());
        MarkerEntity savedData = markerRepository.save(markerEntity);

        MarkerDto savedMarkerDto = new MarkerDto();
        savedMarkerDto.setId(savedData.getId());
        return savedMarkerDto;
    }

    @Override
    public void updatemarker(MarkerDto updatedMarkerDto, Long markerDtoId) {
        MarkerEntity entity = markerRepository.findOne(markerDtoId);

        entity.setName(updatedMarkerDto.getName());
        entity.setId(updatedMarkerDto.getId());
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
}

