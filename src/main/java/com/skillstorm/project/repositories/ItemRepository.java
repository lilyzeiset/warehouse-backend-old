package com.skillstorm.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
