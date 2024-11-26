package com.boratoroslu.movieapp.dto;

import com.boratoroslu.movieapp.domain.Film;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {

    private Long id;


    @NotBlank(message = "Film adı boş bırakılamaz!")  //film adı boş ve null olamaz. notblank kullandık.
    @Size(min = 2,max = 50, message = "Film adı '${validatedValue}' {min} ve {max} arasında olmalı!")
    private String filmName;

    @NotBlank(message = "Film yılı boş bırakılamaz!")  //film yılı boş ve null olamaz. notblank kullandık.
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "Film yapımcısı boş bırakılamaz!")
    @Size(min = 2,max = 20, message = "Film yapımcısı '${validatedValue}' {min} ve {max} arasında olmalı!")
    private String producer;

    @NotBlank(message = "Film türü boş bırakılamaz!")
    @Size(min = 2,max = 25, message = "Film türü '${validatedValue}' {min} ve {max} arasında olmalı!")
    private String genre;

    public FilmDTO(Film film) {
        this.id = film.getId();
        this.filmName = film.getFilmName();
        this.releaseYear = film.getReleaseYear();
        this.imdbRating = film.getImdbRating();
        this.producer = film.getProducer();
        this.genre = film.getGenre();
    }
}
