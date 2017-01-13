package io.swagger.api;

import io.swagger.model.Marker;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-12T00:25:46.196+01:00")

@Api(value = "marker", description = "the marker API")
public interface MarkerApi {

    @ApiOperation(value = "Fetch marker", notes = "Delete one stored marker by Id from database", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successfull", response = Void.class) })
    @RequestMapping(value = "/marker/{markerId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletemarkerById(@ApiParam(value = "specific marker id",required=true ) @PathVariable("markerId") Long markerId);


    @ApiOperation(value = "Fetch markers", notes = "Fetch all stored marker from database", response = Marker.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Marker.class) })
    @RequestMapping(value = "/marker",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Marker>> loadAllmarker();


    @ApiOperation(value = "Fetch marker", notes = "Fetch one stored marker by Id from database", response = Marker.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Marker.class) })
    @RequestMapping(value = "/marker/{markerId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Marker> loadmarkerById(@ApiParam(value = "specific marker id",required=true ) @PathVariable("markerId") Long markerId);


    @ApiOperation(value = "Register  a marker", notes = "Endpoint for registering a marker", response = Marker.class, tags={ "marker", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "marker added successfully", response = Marker.class) })
    @RequestMapping(value = "/marker",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Marker> register(@ApiParam(value = "Request for registering a marker" ,required=true ) @RequestBody Marker marker);


    @ApiOperation(value = "", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/marker/{markerId}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> updatemarker(@ApiParam(value = "Request for updating a specific marker" ,required=true ) @RequestBody Marker marker);

}
