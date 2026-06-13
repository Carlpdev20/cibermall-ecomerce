package com.cibermall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibermall.entity.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Integer > {

}
