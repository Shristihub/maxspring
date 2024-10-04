package com.doctorapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hospital {

	@Column(length = 30)
	private String hospitalName;
	@Id
	@GeneratedValue(generator = "hospital_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="hospital_gen",sequenceName = "hospital_seq",initialValue = 100,allocationSize = 1)
	private Integer hospitalId;
	@Column(length = 20)
	private String city;
	private String type;
	
	@OneToMany(mappedBy = "hospital")
	private List<Doctor> doctors;
	public Hospital(String hospitalName, String city, String type) {
		super();
		this.hospitalName = hospitalName;
		this.city = city;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", hospitalId=" + hospitalId + ", city=" + city + ", type="
				+ type + "]";
	}
	
	
	
	
	
	
	
}
