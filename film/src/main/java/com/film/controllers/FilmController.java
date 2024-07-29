package src.main.java.com.film.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.film.models.Film;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {

    private static List <Film> films =new ArrayList<>();

    public FilmController() {
        films.add(new Film(1, "Inception", "Christopher Nolan","Un ladrón que roba secretos corporativos a través del uso de la tecnología de compartir sueños es dado la tarea inversa de plantar una idea en la mente de un director ejecutivo", 8.8, "Altamente aclamada por la crítica, con una calificación de 8.8/10 en IMDb",2010));
        films.add(new Film(2, "Tenet", "Christopher Nolan","Un agente secreto debe manipular el flujo del tiempo para evitar que el mundo sea destruido.", 7.5, "Tenet recibió críticas mixtas a positivas, con elogios por sus efectos visuales y ambición.",2020));

    }

    @GetMapping("/films")
    public List<Film> getAllFilms(){return films;}
}
