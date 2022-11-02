package com.springboot.hospitalserchapi.controller;

import com.springboot.hospitalserchapi.dao.HospitalDao;
import com.springboot.hospitalserchapi.domain.Hospital;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class HospitalController {

    private final HospitalDao hospitalDao;


    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<String> findById(@PathVariable String id) throws SQLException {
        Hospital hospital = hospitalDao.findById(Integer.parseInt(id));
        String str = hospital.getHospitalName()+"\n"+
                hospital.getFullAddress()+"\n"+
                hospital.getRoadNameAddress()+"\n"+
                hospital.getHealthcareProviderCount()+"\n"+
                hospital.getTotalNumberOfBeds()+"\n"+
                hospital.getTotalAreaSize()+"\n"+
                hospital.getBusinessStatus();

        return ResponseEntity
                .ok()
                .body(str);

    }
}
