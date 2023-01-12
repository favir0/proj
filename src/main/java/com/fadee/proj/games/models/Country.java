package com.fadee.proj.games.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 350)
    private String flag_image;

    protected Country() {}
    public Country(String name, String flag_image) {
        this.name = name;
        this.flag_image = flag_image;
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

    public String getFlag_image() {
        return flag_image;
    }

    public void setFlag_image(String flag_image) {
        this.flag_image = flag_image;
    }
}
