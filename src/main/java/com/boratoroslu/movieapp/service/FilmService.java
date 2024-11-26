package com.boratoroslu.movieapp.service;

import com.boratoroslu.movieapp.domain.Film;
import com.boratoroslu.movieapp.dto.FilmDTO;
import com.boratoroslu.movieapp.exception.ResourceNotFoundException;
import com.boratoroslu.movieapp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    //NOT: Get ALL films
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
    //NOT: create a new film
    public void createNewFilm(Film film) {
        filmRepository.save(film);
    }
    //NOT: get a film
    public Film findFilm(Long id) {
        return filmRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException(id + " numaralı film bulunamadı!"));
    }
    //NOT: delete film
    public void deleteFilm(Long id) {
      Film film = findFilm(id);
      filmRepository.delete(film);

    }
    //NOT: update film
    public void updateFilm(Long id, FilmDTO filmDTO) {
        Film film = findFilm(id);

        film.setFilmName(filmDTO.getFilmName());
        film.setReleaseYear(filmDTO.getReleaseYear());
        film.setImdbRating(filmDTO.getImdbRating());
        film.setProducer(filmDTO.getProducer());
        film.setGenre(filmDTO.getGenre());

        filmRepository.save(film);
    }


}
