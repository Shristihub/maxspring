package com.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	//derived
	  List<Doctor> findByAddressCity(String city);
	 
	  //custom query
	  @Query("from Doctor d inner join d.insurance i where i.type=?1")
	  List<Doctor> findByInsType(String type);
	  
	  @Query("from Doctor d inner join d.speciality s where s.specialityName=?1")
	  List<Doctor> findWithSpeciality(String speciality);
	  
	  @Query("from Doctor d inner join d.hospital h where h.hospitalName=?1")
	  List<Doctor> findByHospitalName(String hospitalName);
	  
	  @Query("""
	  		from Doctor d inner join d.hospital h 
	  		inner join d.speciality s where h.hospitalName=?1 
	  		and s.specialityName=?2 
	  		""" )
	  List<Doctor> findByHospitalSpeciality(String hospitalName, String speciality);
	  
	  @Query("""
		  		from Doctor d inner join d.speciality s where s.specialityName=?1 
		  		and d.experience>?2 
		  		""" )
	  List<Doctor> findBySpecialityAndExp(String speciality, int experience);
	  
	  @Query("""
		  		from Doctor d inner join d.speciality s where s.specialityName=?1 
		  		and d.fees<?2 
		  		""" )
	  List<Doctor> findBySpecialityAndFees(String speciality, double fees);
	  
	  @Query("""
		  		from Doctor d inner join d.speciality s
		  		inner join d.address a where s.specialityName=?1 
		  		and a.city = ?2 
		  		""" )
	  List<Doctor> findBySpecialityAndCity(String speciality, String city);
	  
	  // updating
	  //projections
}
