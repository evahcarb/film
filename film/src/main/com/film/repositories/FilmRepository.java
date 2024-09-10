package com.film.repositories;

import com.film.models.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends MongoRepository<Film, Integer> {
    List<Film> findByName(String name);
    List<Film> findByDirector(String director);
    List<Film> findByRankingGreaterThanEqual(double ranking);
    List<Film> findByYear(int year);
}

