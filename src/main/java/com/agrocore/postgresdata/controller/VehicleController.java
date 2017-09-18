package com.agrocore.postgresdata.controller;


import com.agrocore.postgresdata.model.request.AddVehicleRequest;
import com.agrocore.postgresdata.model.Vehicle;
import com.agrocore.postgresdata.repository.VehicleRepository;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.geotools.geojson.geom.GeometryJSON;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.geometry.text.WKTParser;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping(value = "/{name}")
    public Vehicle findByName(@PathVariable final String name){
        return vehicleRepository.findByName(name);
    }

    @GetMapping(value = "/all")
    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }


    @PostMapping(value = "/load")
    public Vehicle load(@RequestBody final Vehicle vehicle){
        vehicleRepository.save(vehicle);
        return vehicleRepository.findByName(vehicle.getName());
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void addVehicle(@RequestBody Vehicle vehicle) throws IOException, ParseException {
//        vehicleRepository.save(vehicle);
//    }
}
