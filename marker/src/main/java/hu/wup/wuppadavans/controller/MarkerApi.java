package hu.wup.wuppadavans.controller;

import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarkerApi {

    private MarkerService markerService;

    protected MarkerApi() {}

    @Autowired
    public void setMarkerService(MarkerService markerService) {

        this.markerService = markerService;

    }


    @RequestMapping(value = "/hu/wup/wuppadavans/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId) {
        return markerService.deletemarkerById(markerId);
    }


    @RequestMapping(value = "/hu/wup/wuppadavans/model",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Marker>> loadAllmarker() {
        return markerService.loadAllmarker();
    }


    @RequestMapping(value = "/hu/wup/wuppadavans/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId) {
        return markerService.loadmarkerById(markerId);
    }


    @RequestMapping(value = "/hu/wup/wuppadavans/model",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Marker> register(@RequestBody Marker marker) {
        return markerService.register(marker);
    }


    @RequestMapping(value = "/hu/wup/wuppadavans/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> updatemarker(@RequestBody Marker marker) {
        return null;
    }

}
