package katas;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

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
	
	
	return movies.stream()
			.reduce(binaryOperatorLargerstRating())
			.map(Movie::getRating).orElse(0.0);

    }
    
    public static BinaryOperator<Movie>  binaryOperatorLargerstRating(){
    	return (movie1, movie2) -> movie1.getRating() > movie2.getRating() ? movie1 : movie2;
    }
}
