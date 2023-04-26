package com.skillstorm.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project.models.Lot;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long>{

}
