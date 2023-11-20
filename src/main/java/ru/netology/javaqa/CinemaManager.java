package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.List;

public class CinemaManager {
    private final List<Movie> movies;
    private final int limit;

    public CinemaManager() {
        this.movies = new ArrayList<>();
        this.limit = 5;
    }

    public CinemaManager(int limit) {
        this.movies = new ArrayList<>();
        this.limit = limit;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findAll() {
        return movies;
    }

    public List<Movie> findLast() {
        int size = Math.min(limit, movies.size());
        return movies.subList(movies.size() - size, movies.size());
    }

}
