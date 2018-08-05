package com.cb.springdata.sample.controllers;

import com.cb.springdata.sample.entities.Building;
import com.cb.springdata.sample.service.BuildingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buildmanagement/")
public class BuildingController {

    @Autowired
    BuildingServiceImpl buildingService;

    @RequestMapping(value = "/build/", method = RequestMethod.POST)
    public String createBuilding(@RequestBody Building building){

        System.out.println("Entered into create building method"+building.id);
        System.out.println("Entered into create building method");
        System.out.println("Entered into create building method");

        Building buildingSaved = buildingService.save(building);
        if(buildingSaved!= null){
            return "Saved Successfully";
        }else{
            return "Error while saving";
        }
    }

    @RequestMapping(value ="/details/{id}", method=RequestMethod.GET)
    public ResponseEntity<Building> getBuildingDetails(@PathVariable("id") String id){
        Building building =  buildingService.findById(id);
        System.out.println("building id"+ building.id);
        System.out.println("building id"+ building.name);
         return new ResponseEntity<Building>(building, HttpStatus.OK);
    }

    @RequestMapping(value = "/collapsebuilding/{id}", method = RequestMethod.DELETE)
    public void collapseBuilding(@PathVariable("id") String id){
         buildingService.collapseBuilding(id);
    }

    @RequestMapping(value = "/countByCompany/{id}", method = RequestMethod.GET)
    public ResponseEntity<Long>  countBuildings(@PathVariable("id") String id){
    Long count = buildingService.countBuildings(id);
    return new ResponseEntity<Long>(count, HttpStatus.OK);
    }

    @RequestMapping(value = "byPhone/{phone}", method = RequestMethod.GET)
    public ResponseEntity<List<Building>> getBuildingDetailsByPhone(@PathVariable("phone") String phone){
        List<Building> buildings = buildingService.findByPhoneNumber(phone);
        return new ResponseEntity<List<Building>>(buildings, HttpStatus.OK);
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(){
        System.out.println("Entered into create building method");

    }


}
