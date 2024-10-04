package com.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	IDoctorRepository doctorRepository;

	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		doctorRepository.save(doctor);
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteById(doctorId);
		
	}

	@Override
	public Doctor getById(int doctorId) {
		return doctorRepository.findById(doctorId)
				.orElseThrow(()->new DoctorNotFoundException("invalid id for doctor"));
	}

	@Override
	public List<Doctor> getAll() {
		return doctorRepository.findAll();
	}

	@Override
	public List<Doctor> getByCity(String city) {
		return doctorRepository.findByAddressCity(city);
	}

	@Override
	public List<Doctor> getByInsuranceType(String type) {
		return doctorRepository.findByInsType(type);
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		return doctorRepository.findWithSpeciality(speciality);
	}

	@Override
	public List<Doctor> getByHospital(String hospitalName) {
		return doctorRepository.findByHospitalName(hospitalName);
	}

	@Override
	public List<Doctor> getByHospitalSpeciality(String hospitalName, String speciality) {
		return doctorRepository.findByHospitalSpeciality(hospitalName, speciality);
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) {
		return doctorRepository.findBySpecialityAndExp(speciality, experience);
	}

	@Override
	public List<Doctor> getBySpecialityAndfees(String speciality, double fees) {
		return doctorRepository.findBySpecialityAndFees(speciality, fees);
	}

	@Override
	public List<Doctor> getBySpecialityAndCity(String speciality, String city) {
		return doctorRepository.findBySpecialityAndCity(speciality, city);
	}

	
}
