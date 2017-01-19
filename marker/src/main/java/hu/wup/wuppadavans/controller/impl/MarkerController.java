package hu.wup.wuppadavans.controller.impl;

import hu.wup.wuppadavans.controller.MarkerApi;
import hu.wup.wuppadavans.model.Marker;
import hu.wup.wuppadavans.service.MarkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by szvarga on 2017. 01. 19..
 */

@RestController
public class MarkerController implements MarkerApi {


    protected MarkerController() {

    }

    @Override
    public void setMarkerService(MarkerService markerService) {

    }

    @Override
    public ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Marker>> loadAllmarker() {
        return null;
    }

    @Override
    public ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId) {
        return null;
    }

    @Override
    public ResponseEntity<Marker> register(@RequestBody Marker marker) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatemarker(@RequestBody Marker marker, @PathVariable("markerId") Long markerId) {
        return null;
    }
}
