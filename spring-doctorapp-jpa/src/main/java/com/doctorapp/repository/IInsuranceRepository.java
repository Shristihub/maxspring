package com.doctorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Insurance;

@Repository
public interface IInsuranceRepository extends JpaRepository<Insurance, Integer>{

}
