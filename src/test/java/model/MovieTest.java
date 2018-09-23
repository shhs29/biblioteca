package model;

import model.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @DisplayName("should return a movie called The Fault In Our Stars")
    @Test
    void shouldReturnMovie() {
        Movie movie = new Movie("The Fault In Our Stars", "John Green", "2016", 0);
        Movie movie1 = new Movie("The Fault In Our Stars", "John Green", "2016", 0);
        assertEquals(movie, movie1);
    }

    @DisplayName("should return a movie called The Fault In Our Stars and Paper Towns")
    @Test
    void shouldReturnMovie1() {
        Movie movie1 = new Movie("The Fault In Our Stars", "John Green", "2016", 0);
        Movie movie2 = new Movie("Paper Towns", "John Green", "2017", 0);
        Movie movie3 = new Movie("The Fault In Our Stars", "John Green", "2016", 0);
        Movie movie4 = new Movie("Paper Towns", "John Green", "2017", 0);
        assertAll(() -> assertEquals(movie3, movie1),
                () -> assertEquals(movie4, movie2));
    }

    @DisplayName("should return the name, director, year of releasing and rating of a movie")
    @Test
    void shouldReturnMovieDetails() {
        Movie movie = new Movie("The Fault In Our Stars", "John Green", "2016", 0);
        assertEquals("The Fault In Our Stars,John Green,2016,Unrated",movie.toString());
    }
}