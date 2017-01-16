package hu.wup.wuppadavans.service;

import hu.wup.wuppadavans.model.Marker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MarkerService {

    ResponseEntity<Void> deletemarkerById(@PathVariable("markerId") Long markerId);

    ResponseEntity<List<Marker>> loadAllmarker();

    ResponseEntity<Marker> loadmarkerById(@PathVariable("markerId") Long markerId);

    ResponseEntity<Marker> register(@RequestBody Marker marker);
}
