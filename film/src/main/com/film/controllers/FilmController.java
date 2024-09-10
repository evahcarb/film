package com.film.controllers;

import com.film.models.Film;
import com.film.models.Response;
import com.film.repositories.FilmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    @GetMapping
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable("id") int id) {
        return filmRepository.findById(id).orElse(null);
    }

    @GetMapping("/name/{name}")
    public List<Film> getFilmsByName(@PathVariable("name") String name) {
        return filmRepository.findByName(name);
    }

    @GetMapping("/director/{director}")
    public List<Film> getFilmsByDirector(@PathVariable("director") String director) {
        return filmRepository.findByDirector(director);
    }

    @GetMapping("/ranking/{ranking}")
    public List<Film> getFilmsByRanking(@PathVariable("ranking") double ranking) {
        return filmRepository.findByRankingGreaterThanEqual(ranking);
    }

    @GetMapping("/year/{year}")
    public List<Film> getFilmsByYear(@PathVariable("year") int year) {
        return filmRepository.findByYear(year);
    }

    @PostMapping
    public Response saveFilm(@RequestBody Film film) {
        Response response = new Response();
        filmRepository.save(film);
        response.setStatus(200);
        response.setMessage("Saved film with id " + film.getIdFilm() + " and title " + film.getName());
        return response;
    }

    @PutMapping("/{id}")
    public String updateFilm(@PathVariable("id") Integer id, @RequestBody Film film) {
        Film existingFilm = filmRepository.findById(id).orElse(null);
        if (existingFilm != null) {
            existingFilm.setName(film.getName());
            existingFilm.setDirector(film.getDirector());
            existingFilm.setSynopsis(film.getSynopsis());
            existingFilm.setRanking(film.getRanking());
            existingFilm.setReviews(film.getReviews());
            existingFilm.setYear(film.getYear());
            filmRepository.save(existingFilm);
            return "Updated film with id " + id;
        } else {
            return "Film with id " + id + " not found.";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteFilm(@PathVariable("id") Integer id) {
        Film existingFilm = filmRepository.findById(id).orElse(null);
        if (existingFilm != null) {
            filmRepository.delete(existingFilm);
            return "Deleted film with id " + id;
        } else {
            return "Film with id " + id + " not found.";
        }
    }
}
