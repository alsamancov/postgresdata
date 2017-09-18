package com.agrocore.postgresdata.controller;

import com.agrocore.postgresdata.model.Driver;
import com.agrocore.postgresdata.model.request.AddDriverRequest;
import com.agrocore.postgresdata.repository.DriverRepository;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private DriverRepository driverRepository;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    @GetMapping(value="/all")
    public List<Driver> findAll(){
        return driverRepository.findAll();
    }


    @GetMapping(value="/{name}")
    public Driver findByName(@PathVariable final String name){
        return driverRepository.findByName(name);
    }

    @PostMapping(value="/load")
    public Driver load(@RequestBody final Driver driver){
        driverRepository.save(driver);
        return driverRepository.findByName(driver.getName());
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Driver> findAllDrivers(){
//        return driverRepository.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public void addDriver(@RequestBody Driver driver) throws IOException, ParseException {
//        driverRepository.save(driver);
//    }
}
