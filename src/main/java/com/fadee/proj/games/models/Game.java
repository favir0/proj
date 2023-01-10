package com.fadee.proj.games.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Genre genre;
    private Boolean is_multi_player;
    private String description;
    private Float price;
    private Date date;
    private String game_image;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Publisher publisher;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Developer developer;

    protected Game() {}
    public Game(String name, Genre genre, Boolean is_multi_player, String description, Float price, Date date, String game_image, Publisher publisher, Developer developer) {
        this.name = name;
        this.genre = genre;
        this.is_multi_player = is_multi_player;
        this.description = description;
        this.price = price;
        this.date = date;
        this.game_image = game_image;
        this.publisher = publisher;
        this.developer = developer;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Boolean getIs_multi_player() {
        return is_multi_player;
    }

    public void setIs_multi_player(Boolean is_multi_player) {
        this.is_multi_player = is_multi_player;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGame_image() {
        return game_image;
    }

    public void setGame_image(String game_image) {
        this.game_image = game_image;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
