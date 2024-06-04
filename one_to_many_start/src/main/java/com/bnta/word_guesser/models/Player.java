package com.bnta.word_guesser.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "player")
    @JsonIgnoreProperties({"player"})//this will look for the player object inside Game object
    @Column(name = "games")
    private List<Game> games;

    public Player(String name) {
        this.name = name;
        this.games = new ArrayList<>();
    }
//    this is for us, to create java objects

    public Player(){

    }
//   this, the default constructor, is how Spring works and gets the getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
