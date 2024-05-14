package com22.rest1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String location;
    private int numberOfEmployees;
    @OneToMany(mappedBy = "restaurant")
    private List<User> users;
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;
}
