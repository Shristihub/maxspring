package com.doctorapp.service;

import com.doctorapp.model.Speciality;

public interface ISpecialityService {
	
	//crud operation
	void addSpeciality(Speciality speciality);
	void updateSpeciality(Speciality speciality);
	void deleteSpeciality(int specialityId);
	Speciality getById(int specialityId);
	
	
}
