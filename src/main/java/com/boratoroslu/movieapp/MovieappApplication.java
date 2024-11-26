package com.boratoroslu.movieapp;

import com.boratoroslu.movieapp.domain.Film;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);

		Film film = new Film();



	}

}
