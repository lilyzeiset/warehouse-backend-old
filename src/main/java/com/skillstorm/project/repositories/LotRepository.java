package com.skillstorm.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.project.models.Lot;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long>{

	@Query("select l from Lot l where l.warehouse_id = ?1")
	public List<Lot> findAllLotsByWarehouseId(long warehouse_id);

}
