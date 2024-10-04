package com.doctorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Hospital;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Integer>{

}
