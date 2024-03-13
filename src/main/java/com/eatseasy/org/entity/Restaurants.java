package com.eatseasy.org.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "restaurants", uniqueConstraints = @UniqueConstraint(columnNames = {"nom"}))
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    public Restaurants(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
