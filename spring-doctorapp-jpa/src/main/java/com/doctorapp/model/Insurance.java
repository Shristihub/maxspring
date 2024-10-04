package com.doctorapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Insurance {
	
	@Column(length = 30)
	private String insuranceName;
	@Column(length = 20)
	private String insuranceProvider;
	@Id
	@GeneratedValue(generator = "ins_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="ins_gen",sequenceName = "insurance_seq",initialValue = 50,allocationSize = 1)
	private Integer insuranceId;
	private int term;
	@Column(length = 20)
	private String type; // health,vehicle,travel,life,property
	
	public Insurance(String insuranceName, String insuranceProvider, int term, String type) {
		super();
		this.insuranceName = insuranceName;
		this.insuranceProvider = insuranceProvider;
		this.term = term;
		this.type = type;
	}



}
