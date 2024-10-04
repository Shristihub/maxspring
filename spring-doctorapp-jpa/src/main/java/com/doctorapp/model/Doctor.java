package com.doctorapp.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Doctor {
	private String doctorName;
	@Id
	@GeneratedValue(generator = "doc_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="doc_gen",sequenceName = "doctor_seq",initialValue = 1,allocationSize = 1)
	private Integer doctorId;
	private double fees;
	private int experience;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id") // foreign key
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	// column name doc_id references to doctor_id of doctor table 
	@JoinColumn(name = "doc_id") // doctorid added as foreign key  to insurance table
	private Set<Insurance> insurance;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id") // foreign key
	private Hospital hospital;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name="doctor_speciality",
			 joinColumns=
	            @JoinColumn(name="doctor_id"),
	        inverseJoinColumns=
	            @JoinColumn(name="speciality_Id")
	    )

	private Set<Speciality> speciality;
	public Doctor(String doctorName, double fees, int experience, Address address, Set<Insurance> insurance,
			Hospital hospital, Set<Speciality> speciality) {
		super();
		this.doctorName = doctorName;
		this.fees = fees;
		this.experience = experience;
		this.address = address;
		this.insurance = insurance;
		this.hospital = hospital;
		this.speciality = speciality;
	}
	

}
