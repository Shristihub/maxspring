package com.doctorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.exception.SpecialityNotFoundException;
import com.doctorapp.model.Speciality;
import com.doctorapp.repository.ISpecialityRepository;

@Service
public class SpecialityServiceImpl implements ISpecialityService {

	@Autowired
	private ISpecialityRepository specialityRepository;
	
	@Override
	public void addSpeciality(Speciality speciality) {
		specialityRepository.save(speciality);
	}

	@Override
	public void updateSpeciality(Speciality speciality) {
		specialityRepository.save(speciality);

	}

	@Override
	public void deleteSpeciality(int specialityId) {
		specialityRepository.deleteById(specialityId);
	}

	@Override
	public Speciality getById(int specialityId) {
		return specialityRepository.findById(specialityId)
				.orElseThrow(()-> new SpecialityNotFoundException("invalid id"));
	}

}
