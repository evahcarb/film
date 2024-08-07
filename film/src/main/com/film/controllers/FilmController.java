package com.film.controllers;

import com.film.models.Film;
import com.film.models.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class FilmController {

    private static List <Film> films =new ArrayList<>();

    public FilmController() {
        films.add(new Film(1, "Inception", "Christopher Nolan","Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños es dado la tarea inversa de plantar una idea en la mente de un director ejecutivo", 8.8, "Altamente aclamada por la crítica, con una calificación de 8.8/10 en IMDb",2010));
        films.add(new Film(2, "Tenet", "Christopher Nolan","Un agente secreto debe manipular el flujo del tiempo para evitar que el mundo sea destruido.", 7.5, "Tenet recibió críticas mixtas a positivas, con elogios por sus efectos visuales y ambición.",2020));

    }

    @GetMapping("/films")
    public List<Film> getAllFilms(){return films;}

     @GetMapping("/films/{id}")
    public Film getFilmId(@PathVariable ("id") int id){
         for (Film i : films) {
             if(i.getIdFilm() == id){
                 return i;
             }

         }
         return null;
     }

    @GetMapping("/films/name/{name}")
    public List<Film> getFilmName(@PathVariable("name") String name) {
        List<Film> matchingFilms = new ArrayList<>();
        for (Film film : films) {
            if (film.getName().equals(name)) {
                matchingFilms.add(film);
            }
        }

        return matchingFilms;
    }

    @GetMapping("/films/director/{director}")
    public List <Film> getFilmDirector (@PathVariable("director") String director){
        return films.stream()
                .filter(i -> i.getDirector().equals(director))
                .collect(Collectors.toList());
    }

    @GetMapping("/films/ranking/{ranking}")
    public List <Film> getFilmRanking (@PathVariable("ranking")double ranking){
        List <Film> rankingFilms=new ArrayList<>();
        for(Film i:films){
            if(i.getRanking() >= ranking){
                rankingFilms.add(i);
            }
        }
        return rankingFilms;
    }

    @GetMapping("/films/year/{year}")
    public List <Film> getFilmYear(@PathVariable("year")double year){
        List <Film> yearFilms=new ArrayList<>();
        for(Film i:films){
            if(i.getYear() == year){
                yearFilms.add(i);
            }
        }
        return yearFilms;
    }

    @PostMapping("/films")
    public Response saveFilms(@RequestBody Film film) {
        Response response = new Response();
        films.add(film);
        response.setStatus(200);
        response.setMessage("I save a movie with id " + film.getIdFilm() + " and title " + film.getName());
        return response;
    }

    @PutMapping("/films/{id}")
    public String updateFilm(@PathVariable("id") Integer id, @RequestBody Film film) {
        for (Film i : films) {
            if (i.getIdFilm() == id) {
                i.setName(film.getName());
                i.setDirector(film.getDirector());
                i.setSynopsis(film.getSynopsis());
                i.setRanking(film.getRanking());
                i.setReviews(film.getReviews());
                i.setYear(film.getYear());
                return "You updated Film: Id: " + film.getIdFilm() + " with the new Name: " + film.getName();
            }
        }
        return "Film with Id: " + id + " not found.";
    }

    @DeleteMapping("/films/{id}")
    public String deleteFilm(@PathVariable("id") Integer id) {
        for (Film i : films) {
            if (i.getIdFilm() == id) {
                films.remove(i);
                return "Film with Id: " + id + " has been deleted";
            }
        }
        return "Film with Id: " + id + " not found.";
    }
}
