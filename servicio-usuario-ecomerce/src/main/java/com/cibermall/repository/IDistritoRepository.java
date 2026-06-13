package com.cibermall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibermall.entity.Distrito;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito,Integer > {
	
}


