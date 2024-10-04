package com.doctorapp.model;

public enum Specialisation {

	ORTHO("Orthopaedician"),
	PHYSICIAN("General Physician"),
	ONCO("Oncologist"),
	SURGERY("Surgeon"),
	ENT("ENT Specialist"),
	GYNAEC("Gynaecologist");
	
	private String specialityType;

	private Specialisation(String specialityType) {
		this.specialityType = specialityType;
	}

	public String getSpecialityType() {
		return specialityType;
	}

	
}
