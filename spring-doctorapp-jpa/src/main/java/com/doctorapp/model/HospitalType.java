package com.doctorapp.model;

public enum HospitalType {

	KIDS("CHILDRENS SPECILAITY HOSPITAL"),
	ORTHO("ORTHO CLINIC"),
	WOMEN("MATERNITY HOSPITAL"),
	MULTI("MULTI SPECIALITY HOSPITAL"),
	POLY("POLY CLINIC"),
	DIABETIC("DIABETIC HOSPITAL"),
	EYE("EYE SPECIALITY CARE");
	
	private String type;

	private HospitalType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
}
