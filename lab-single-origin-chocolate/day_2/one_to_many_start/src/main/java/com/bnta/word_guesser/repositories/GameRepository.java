package com.bnta.word_guesser.repositories;

import com.bnta.word_guesser.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByCompleteTrue();
}
