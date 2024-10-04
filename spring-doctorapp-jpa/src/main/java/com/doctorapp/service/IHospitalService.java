package com.doctorapp.service;

import java.util.List;

import com.doctorapp.model.Hospital;

public interface IHospitalService {
	
	
	//crud operation
	void addHospital(Hospital hospital);
	void addManyHospital(Hospital... hospitals);
	void updateHospital(Hospital hospital);
	void deleteHospital(int hospitalId);
	Hospital getById(int hospitalId);
	
	List<Hospital> getAll();
	List<Hospital> getByCity(String city);
	List<Hospital> getBySpeciality(String speciality);
	
}
