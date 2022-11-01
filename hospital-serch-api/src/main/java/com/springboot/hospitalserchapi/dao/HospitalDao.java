package com.springboot.hospitalserchapi.dao;

import com.springboot.hospitalserchapi.domain.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //List<Hospital> 11만건 Hospital 하나씩 add
    public void add(Hospital hospital) {
        String sql = "INSERT INTO `likelion-db`.`nation_wide_hospitals` (`id`, `open_service_name`, `open_local_government_code`, `management_number`, `license_date`, `business_status`, `business_status_code`, `phone`, `full_address`, `road_name_address`, `hospital_name`, `business_type_name`, `healthcare_provider_count`, `patient_room_count`, `total_number_of_beds`, `total_area_size`) " +
                "VALUES (?,?,?," +
                "?,?,?," +
                "?,?,?," +
                "?,?,?," +
                "?,?,?," +
                "?);"; //16개 columns

        this.jdbcTemplate.update(sql, hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(), hospital.getFullAddress(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(),
                hospital.getTotalAreaSize()
        );

    }

    public int getCount() {
        String sql = "SELECT COUNT(id) from nation_wid_hospitals";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
