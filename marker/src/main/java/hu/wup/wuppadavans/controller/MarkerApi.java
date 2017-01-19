package hu.wup.wuppadavans.controller;

import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MarkerApi {


    @Autowired
    public void setMarkerService(MarkerService markerService);


    @RequestMapping(value = "/hu/wup/wuppadavans/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/hu/wup/wuppadavans/model",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Marker>> loadAllmarker();


    @RequestMapping(value = "/hu/wup/wuppadavans/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/hu/wup/wuppadavans/model",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Marker> register(@RequestBody Marker marker);


    @RequestMapping(value = "/hu/wup/wuppadavans/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> updatemarker(@RequestBody Marker marker, @PathVariable("markerId") Long markerId);

}
