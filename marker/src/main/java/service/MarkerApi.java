package service;

import model.Marker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public interface MarkerApi {

    @RequestMapping(value = "/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/model",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<Marker>> loadAllmarker();


    @RequestMapping(value = "/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId);


    @RequestMapping(value = "/model",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Marker> register(@RequestBody Marker marker);


    @RequestMapping(value = "/model/{markerId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> updatemarker(@RequestBody Marker marker);

}
