package com.doctorapp.service;

import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorService {
	
	
	//crud operation
	void addDoctor(Doctor doctor);
	void updateDoctor(Doctor doctor);
	void deleteDoctor(int doctorId);
	Doctor getById(int doctorId);
	
	List<Doctor> getAll();
	List<Doctor> getByCity(String city);
	List<Doctor> getByInsuranceType(String type);
	List<Doctor> getBySpeciality(String speciality);
	List<Doctor> getByHospital(String hospitalName);
	List<Doctor> getByHospitalSpeciality(String hospitalName,String speciality);
	List<Doctor> getBySpecialityAndExp(String speciality, int experience);
	List<Doctor> getBySpecialityAndfees(String speciality,double fees);
	List<Doctor> getBySpecialityAndCity(String speciality,String city);
}
