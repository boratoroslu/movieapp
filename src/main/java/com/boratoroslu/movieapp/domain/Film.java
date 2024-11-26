package com.boratoroslu.movieapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;


    @NotBlank(message = "Film adı boş bırakılamaz!")  //film adı boş ve null olamaz. notblank kullandık.
    @Size(min = 2,max = 50, message = "Film adı '${validatedValue}' {min} ve {max} arasında olmalı!")
    @Column(nullable = false, length = 50) // veri tabanı kısmında bu kolonun boş geçilemez olduğunu söyledik.
    private String filmName;

    @NotBlank(message = "Film yılı boş bırakılamaz!")  //film yılı boş ve null olamaz. notblank kullandık.
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "Film yapımcısı boş bırakılamaz!")
    @Size(min = 2,max = 20, message = "Film yapımcısı '${validatedValue}' {min} ve {max} arasında olmalı!")
    @Column(nullable = false, length = 20)
    private String producer;

    @NotBlank(message = "Film türü boş bırakılamaz!")
    @Size(min = 2,max = 25, message = "Film türü '${validatedValue}' {min} ve {max} arasında olmalı!")
    @Column(nullable = false, length = 25)
    private String genre;
}
