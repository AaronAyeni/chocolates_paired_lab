package com.bnta.word_guesser.repositories;

import com.bnta.word_guesser.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

//a lot of Jpa stuff is like save and build, already built into it
