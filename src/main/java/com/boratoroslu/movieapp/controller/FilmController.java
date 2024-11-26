package com.boratoroslu.movieapp.controller;

import com.boratoroslu.movieapp.domain.Film;
import com.boratoroslu.movieapp.dto.FilmDTO;
import com.boratoroslu.movieapp.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("films")
@CrossOrigin(origins = "http://locahost:8080")
public class FilmController {
    @Autowired
    private FilmService filmService;

    // !!! Get All films
    @GetMapping //http://localhost:8080/films + GET
    public ResponseEntity<List<Film>> listAllFilms(){
        List<Film> films = filmService.getAllFilms();

        return ResponseEntity.ok(films);
      //  new ResponseEntity(films, HttpStatus.OK;
    }

    // !!! Create a new film
    @PostMapping // http://localhost:8080/films + post +json
    public ResponseEntity<Map<String,String>> createFilm(@Valid @RequestBody Film film){
        filmService.createNewFilm(film);
        Map<String,String> map = new HashMap<>();
        map.put("message", "Film eklendi");
        map.put("status","true");
        //HttpsStatus Code = 201
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    // !!! Get a Film
    @GetMapping("/{id}") // http://localhost:8080/films/1 +GET
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id){

        return ResponseEntity.ok(filmService.findFilm(id));
    }
    // !!! Delete Film
    @DeleteMapping("/{id}")// http://localhost:8080/films/1 +DELETE
    public ResponseEntity<String> deleteFilm(@PathVariable("id") Long id){
        filmService.deleteFilm(id);
        String messeage = "Film Silindi";
        return new ResponseEntity<>(messeage,HttpStatus.OK); // code 200

    }
    // !!! Update Film
    @PutMapping("/{id}")// http://localhost:8080/films/1 +PUT + JSON
    public ResponseEntity<String> updateFilm(@PathVariable("id") Long id,
                                             @Valid @RequestBody FilmDTO filmDTO){
    filmService.updateFilm(id,filmDTO);
        String messeage = "Film Güncellendi";
        return new ResponseEntity<>(messeage,HttpStatus.OK); // code 200
    }
}
