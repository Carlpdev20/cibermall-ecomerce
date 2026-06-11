package com.cibermall.repository;

import com.cibermall.model.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito, Integer> {
}
