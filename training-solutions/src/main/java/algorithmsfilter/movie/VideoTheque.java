package algorithmsfilter.movie;

import java.util.ArrayList;
import java.util.List;

public class VideoTheque {

    List<Movie> movies = new ArrayList<>();

    public List<Movie> getGoodMoviesWithCategoryGiven(Category category) {
        List<Movie> bestMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCategory() == category && movie.getRating() > 3) {
                bestMovies.add(movie);
            }
        }
        return bestMovies;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
