package com.eatseasy.org.api.resource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Resource {@code Restaurant}
 */
@Getter
@Setter
@ToString
@JsonPropertyOrder({
        "id",
        "nom"
})
public class RestaurantResource {

    private Long id;

    private String nom;
}
