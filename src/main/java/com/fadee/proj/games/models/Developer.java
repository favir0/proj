package com.fadee.proj.games.models;

import jakarta.persistence.*;
@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 1500)
    private String description;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;
    protected Developer() {}
    public Developer(String name, String description, Country country) {
        this.name = name;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
