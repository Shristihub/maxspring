package com.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.exception.HospitalNotFoundException;
import com.doctorapp.model.Hospital;
import com.doctorapp.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService{
	
	@Autowired
	private IHospitalRepository hospitalRepository;

	@Override
	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	@Override
	public void updateHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHospital(int hospitalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hospital getById(int hospitalId) {
		return hospitalRepository.findById(hospitalId)
				.orElseThrow(()->new HospitalNotFoundException("invalid id for hospital"));
	}

	@Override
	public List<Hospital> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospital> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospital> getBySpeciality(String speciality) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addManyHospital(Hospital... hospitals) {
		List<Hospital> hospitalList = List.of(hospitals);
		hospitalRepository.saveAll(hospitalList);
	}

}
