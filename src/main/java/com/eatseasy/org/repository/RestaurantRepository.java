package com.eatseasy.org.repository;

import com.eatseasy.org.entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {
    Restaurants findByNom(@Param("nom") String nom);
}
