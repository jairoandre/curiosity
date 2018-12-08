package com.fountainledge.curiosity.controller;

import com.fountainledge.curiosity.model.MarsReport;
import com.fountainledge.curiosity.model.NasaPictureFeed;
import com.fountainledge.curiosity.model.NasaPictureObject;
import com.fountainledge.curiosity.model.WeatherReport;
import com.fountainledge.curiosity.service.CuriosityService;
import com.fountainledge.curiosity.service.NASAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mars")
public class MarsStatusController {

  @Autowired
  CuriosityService curiosityService;

  @Autowired
  NASAService nasaService;

  @RequestMapping("/report")
  @CrossOrigin
  public MarsReport getMarsReport() {
    return curiosityService.getLatestMarsReport();
  }

  @RequestMapping("/report/{date}")
  public ResponseEntity<WeatherReport> getByTerrestrialDate(@PathVariable("date") String date) {
    return Optional.ofNullable(curiosityService.getByTerrestrialDate(date))
        .map(ResponseEntity::ok)
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }


  @RequestMapping("/photos/{earth_date}")
  public ResponseEntity<List<NasaPictureObject>> getPhotos(@PathVariable("earth_date") String earthDate) {
    return Optional.ofNullable(nasaService.getMarsPictures(earthDate))
        .map(ResponseEntity::ok)
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}