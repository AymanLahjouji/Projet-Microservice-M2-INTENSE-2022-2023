package com.howtodoinjava.example.movie.controller;

import com.howtodoinjava.example.movie.beans.acteur;
import com.howtodoinjava.example.movie.beans.film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@Api(value = "Swagger2DemoRestController", description = "REST Apis related to film Entity!!!!")
public class Controller {

    private static final Map<String, acteur> acteurData = new HashMap<String, acteur>() {

        private static final long serialVersionUID = -3970206781360313502L;

        {
            put("Aymen",new acteur("Aymen","Lahjouji","10/01/2000", "Movie1"));
            put("Marwen",new acteur("Marwen","Saidi","05/11/1992","Movie2"));
        }

    };

    private static final Map<String, film> filmData = new HashMap<String, film>() {


        {
            put("Movie1",new film("Movie1","Aymen","22/10/2022",new acteur("Aymen","Lahjouji","10/01/2000","Movie1")));
            put("Movie2",new film("Movie2","Marwen","18/12/2018",new acteur("Marwen","Saidi","05/11/1992","Movie2")));
        }

    };

    @RequestMapping(value = "/findFilmDetails/{filmName}", method = RequestMethod.GET)
    public film getFilmDetails(@PathVariable String filmName) {
        System.out.println("Getting film details for " + filmName);

        film film = filmData.get(filmName);
        if (film == null) {

            film = new film("film n'existe pas", "n'existe pas","0", null);

        }
        return film;
    }

    @RequestMapping(value = "/findActeurDetails/{acteurName}", method = RequestMethod.GET)
    public acteur getActeurDetails(@PathVariable String acteurName) {
        System.out.println("Getting film details for " + acteurName);

        acteur acteur = acteurData.get(acteurName);
        if (acteur == null) {

            acteur = new acteur("n'existe pas","n'exite pas","0", "n'exite pas");

        }
        return acteur;
    }

    @RequestMapping(value = "/getFilms")
    public Map<String,film> getFilms() {
        return filmData;
    }

    @RequestMapping(value = "/getActeurs")
    public Map<String,acteur> getActeurs() {
        return acteurData;
    }


    /*@ApiOperation(value = "Get specific film in the System ", response = film.class, tags = "getFilm")
    @RequestMapping(value = "/getFilm/{titre}")
    public film getFilm(@PathVariable(value = "titre") String titre) {
        return filmData.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }*/

}
