package com.doctorapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.Address;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalType;
import com.doctorapp.model.Insurance;
import com.doctorapp.model.Specialisation;
import com.doctorapp.model.Speciality;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.service.IHospitalService;
import com.doctorapp.service.ISpecialityService;

@SpringBootApplication
public class SpringDoctorappJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappJpaApplication.class, args);
	}
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IHospitalService hospitalService;
	
	@Autowired
	private ISpecialityService specialityService;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Hospital hospital1=  new Hospital("Jayadeva", "Bengaluru", HospitalType.MULTI.getType());
//		Hospital hospital2=  new Hospital("JSS Hospital", "Mysore", HospitalType.WOMEN.getType());
//		Hospital hospital3=  new Hospital("Rainbow Hospital", "Bengaluru", HospitalType.KIDS.getType());
//		Hospital hospital4=  new Hospital("Aster Hospital", "Bengaluru", HospitalType.MULTI.getType());
//		Hospital hospital5=  new Hospital("CloudNine Hospital", "Bengaluru", HospitalType.WOMEN.getType());
//		hospitalService.addManyHospital(hospital1,hospital2,hospital3,hospital4,hospital5);
//		
//		Speciality speciality1 = new Speciality(Specialisation.ONCO.getSpecialityType());
//		Speciality speciality2 = new Speciality(Specialisation.ORTHO.getSpecialityType());
//		specialityService.addSpeciality(speciality1);
//		specialityService.addSpeciality(speciality2);
		
		
//		Address address = new Address("Mysore","Kar");
//		Insurance insurance1 = new Insurance("Ayush Vikas", "MAX", 20, "Life");
//		Insurance insurance2 = new Insurance("Health Spice", "MAX", 20, "health");
//		Set<Insurance> insurances = new HashSet<>(Arrays.asList(insurance1,insurance2));
//		
//		Hospital hospital = hospitalService.getById(104);
//		
////		// get the specialities by id
//		Speciality special1 = specialityService.getById(21);
//		Speciality special2 = specialityService.getById(25);
//		
//		Set<Speciality> specialities = new HashSet<>(Arrays.asList(special1,special2));
//		
//		Doctor doctor = new Doctor("Naveen",200,10,address,insurances,hospital,specialities);
//		doctorService.addDoctor(doctor);
//		
//		System.out.println(".........");
//		System.out.println("By City");
//		doctorService.getByCity("Mysore").forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println(".........");
//		System.out.println("By InsuranceType");
//		doctorService.getByInsuranceType("Life").forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println(".........");
//		System.out.println("By Speciality");
//		doctorService.getBySpeciality(Specialisation.SURGERY.getSpecialityType()).forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println(".........");
//		System.out.println("By Hospital");
//		doctorService.getByHospital("Manipal Hospital").forEach(System.out::println);
//		
		System.out.println();
		System.out.println(".........");
		System.out.println("By Hospital and speciality");
		doctorService.getByHospitalSpeciality("Manipal Hospital",Specialisation.ORTHO.getSpecialityType()).forEach(System.out::println);
		
		System.out.println();
		System.out.println(".........");
		System.out.println("By experience and speciality");
		doctorService.getBySpecialityAndExp(Specialisation.ORTHO.getSpecialityType(),8).forEach(System.out::println);
		
	}

}
