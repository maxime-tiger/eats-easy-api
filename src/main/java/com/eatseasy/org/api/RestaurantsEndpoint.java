package com.eatseasy.org.api;

import com.eatseasy.org.api.resource.RestaurantResource;
import com.eatseasy.org.entity.Restaurants;
import com.eatseasy.org.exception.NoResultException;
import com.eatseasy.org.service.RestaurantsService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ApiConstants.PREFIX + "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantsEndpoint {

    @Autowired
    private RestaurantsService restaurantsService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "")
    public ResponseEntity<Restaurants> getRestaurantById(
            @PathVariable("restauId") Long restauId
    ) {
        Restaurants restaurants = restaurantsService.findOne(restauId);
        if (restaurants == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(restaurants);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getRestaurantByNom(
        @PathVariable("nom") String nom
    ) {
        if (StringUtils.isEmpty(nom)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom ne peut pas être vide.");
        }
        Restaurants restaurants = restaurantsService.findByNom(nom);
        if (restaurants == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(restaurants);
    }

    @PutMapping(value = "/{restauId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> updateRestaurant(
        @PathVariable("restauId") Long restauId,
        @RequestBody RestaurantResource restaurantResource
    ) {
        Restaurants restaurants = mapper.map(restaurantResource, Restaurants.class);
        restaurants.setId(restauId);
        try {
            restaurantsService.update(restaurants);
        }
        catch (NoResultException noResException) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restauId);
    }

    @DeleteMapping(value = "/{restauId}")
    public ResponseEntity<HttpStatus> deleteRestaurant(
            @PathVariable("restauId") Long restauId
    ) {
        Restaurants restaurants = restaurantsService.findOne(restauId);
        try {
            restaurantsService.delete(restaurants);
        }
        catch (NoResultException noResException) {
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
