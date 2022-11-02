package com.springboot.hospitalserchapi.controller;

import com.springboot.hospitalserchapi.dao.HospitalDao;
import com.springboot.hospitalserchapi.domain.Hospital;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class HospitalController {

    private final HospitalDao hospitalDao;


    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/hospital/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable String id) throws SQLException {
        Hospital hospital = hospitalDao.findById(Integer.parseInt(id));
        Optional<Hospital> opt = Optional.of(hospital);

        if (!opt.isEmpty()) {
            return ResponseEntity.ok().body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }

/*        String str = hospital.getHospitalName()+"\n"+
                hospital.getFullAddress()+"\n"+
                hospital.getRoadNameAddress()+"\n"+
                hospital.getHealthcareProviderCount()+"\n"+
                hospital.getTotalNumberOfBeds()+"\n"+
                hospital.getTotalAreaSize()+"\n"+
                hospital.getBusinessStatus();
        */

    }
}
