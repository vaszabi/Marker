package hu.wup.wuppadavans.controller;

import hu.wup.wuppadavans.model.Marker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MarkerApi {


    @RequestMapping(value = "/marker/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    @ResponseBody
    ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/marker",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<Marker>> loadAllmarker();


    @RequestMapping(value = "/marker/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/marker",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Marker> register(@RequestBody Marker marker);


    @RequestMapping(value = "/marker/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Void> updatemarker(@RequestBody Marker marker, @PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/marker/closest",
            produces = {"application/json"},
            method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Marker> closestMarker(@RequestBody Marker marker);

    @RequestMapping(value = "/marker/driving",
            produces = {"application/json"},
            method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Marker> closestMarkerDriving(@RequestBody Marker marker);
}
