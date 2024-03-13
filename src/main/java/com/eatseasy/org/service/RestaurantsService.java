package com.eatseasy.org.service;

import com.eatseasy.org.entity.Restaurants;

public interface RestaurantsService {

    Restaurants findOne(Long id);

    Restaurants findByNom(String nom);

    void save(Restaurants restaurants);

    Restaurants update(Restaurants restaurants);

    void delete(Restaurants restaurants);
}
