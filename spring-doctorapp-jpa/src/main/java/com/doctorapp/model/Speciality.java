package com.doctorapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Speciality {
	@Column(length=30)
	private String specialityName;
	@Id
	@GeneratedValue(generator = "speciality_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="speciality_gen",sequenceName = "speciality_seq",initialValue = 20,allocationSize = 1)
	private int specialityId;
	@ManyToMany
	@JoinTable(name="doctor_speciality",
	 joinColumns=
       @JoinColumn(name="speciality_id"),
   inverseJoinColumns=
       @JoinColumn(name="doctor_Id")
)
	private List<Doctor> doctors;
	
	public Speciality(String specialityName) {
		super();
		this.specialityName = specialityName;
	}
	@Override
	public String toString() {
		return "Speciality [specialityName=" + specialityName + "]";
	}
	
	
	
}
