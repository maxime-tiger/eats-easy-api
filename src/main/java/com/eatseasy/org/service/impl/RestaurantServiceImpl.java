package com.eatseasy.org.service.impl;

import com.eatseasy.org.entity.Restaurants;
import com.eatseasy.org.exception.NoResultException;
import com.eatseasy.org.repository.RestaurantRepository;
import com.eatseasy.org.service.RestaurantsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantServiceImpl implements RestaurantsService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    private ModelMapper mapper;

    /**
     * @param id
     * @return
     */
    @Override
    public Restaurants findOne(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    /**
     * @param nom
     * @return
     */
    @Override
    public Restaurants findByNom(String nom) {
        return restaurantRepository.findByNom(nom);
    }

    /**
     * @param restaurants
     */
    @Override
    public void save(Restaurants restaurants) {
        restaurantRepository.save(restaurants);
    }

    /**
     * @param restaurants
     */
    @Override
    public Restaurants update(Restaurants restaurants) {
        Restaurants restaurantsToUpdate = restaurantRepository.findById(restaurants.getId()).orElse(null);
        if (restaurantsToUpdate == null) {
            throw new NoResultException();
        }
        mapper.map(restaurants, restaurantsToUpdate);
        return restaurantsToUpdate;
    }

    /**
     * @param restaurants
     */
    @Override
    public void delete(Restaurants restaurants) {
        restaurantRepository.delete(restaurants);
    }
}
