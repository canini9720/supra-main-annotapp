package com.supra.annot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supra.annot.model.ApplicationPropertyEntity;




public interface ApplicationPropertyRepository extends JpaRepository<ApplicationPropertyEntity,Long> {
	
	
}
