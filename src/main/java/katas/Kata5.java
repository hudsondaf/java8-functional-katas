package katas;

import java.util.List;
import java.util.Optional;

import model.Movie;
import util.DataUtil;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {

	List<Movie> movies = DataUtil.getMovies();

	Optional<Movie> movie = movies.stream()
		.reduce((movie1, movie2) -> movie1.getRating() > movie2.getRating() ? movie1 : movie2);

	if (movie.isPresent()) {
	    return movie.get().getRating();
	}
	return 0.0;
    }
}
