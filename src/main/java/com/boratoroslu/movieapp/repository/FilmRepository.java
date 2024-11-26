package com.boratoroslu.movieapp.repository;

import com.boratoroslu.movieapp.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {

}
