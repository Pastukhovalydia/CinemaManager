package ru.netology.javaqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;




public class CinemaManagerTest {
    @Mock
    private Movie movie1;
    @Mock
    private Movie movie2;
    @Mock
    private Movie movie3;
    @Mock
    private Movie movie4;
    @Mock
    private Movie movie5;
    @Mock
    private Movie movie6;

    private CinemaManager cinemaManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cinemaManager = new CinemaManager(5);
    }

    @Test
    public void testAddMovie() {
        cinemaManager.addMovie(movie1);
        cinemaManager.addMovie(movie2);
        cinemaManager.addMovie(movie3);

        List<Movie> movies = cinemaManager.findAll();
        assertEquals(Arrays.asList(movie1, movie2, movie3), movies);
    }

    @Test
    public void testFindAll() {
        when(movie1.getTitle()).thenReturn("Movie 1");
        when(movie2.getTitle()).thenReturn("Movie 2");
        when(movie3.getTitle()).thenReturn("Movie 3");
        when(movie4.getTitle()).thenReturn("Movie 4");

        cinemaManager.addMovie(movie1);
        cinemaManager.addMovie(movie2);
        cinemaManager.addMovie(movie3);
        cinemaManager.addMovie(movie4);

        List<Movie> movies = cinemaManager.findAll();
        assertEquals(Arrays.asList(movie1, movie2, movie3, movie4), movies);
    }

    @Test
    public void testFindLastWithLimit() {
        when(movie1.getTitle()).thenReturn("Movie 1");
        when(movie2.getTitle()).thenReturn("Movie 2");
        when(movie3.getTitle()).thenReturn("Movie 3");
        when(movie4.getTitle()).thenReturn("Movie 4");
        when(movie5.getTitle()).thenReturn("Movie 5");
        when(movie6.getTitle()).thenReturn("Movie 6");

        cinemaManager.addMovie(movie1);
        cinemaManager.addMovie(movie2);
        cinemaManager.addMovie(movie3);
        cinemaManager.addMovie(movie4);
        cinemaManager.addMovie(movie5);
        cinemaManager.addMovie(movie6);

        List<Movie> lastMovies = cinemaManager.findLast();
        assertEquals(Arrays.asList(movie2, movie3, movie4, movie5, movie6), lastMovies);
    }

    @Test
    public void testFindLastWithoutLimit() {
        when(movie1.getTitle()).thenReturn("Movie 1");
        when(movie2.getTitle()).thenReturn("Movie 2");
        when(movie3.getTitle()).thenReturn("Movie 3");

        cinemaManager.addMovie(movie1);
        cinemaManager.addMovie(movie2);
        cinemaManager.addMovie(movie3);

        List<Movie> lastMovies = cinemaManager.findLast();
        assertEquals(Arrays.asList(movie1, movie2, movie3), lastMovies);
    }

}
