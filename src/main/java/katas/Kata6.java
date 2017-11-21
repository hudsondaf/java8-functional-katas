package katas;

import java.util.List;
import java.util.Optional;

import model.BoxArt;
import model.Movie;
import util.KatasUtils;
import util.DataUtil;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {

	List<Movie> movies = DataUtil.getMovies();
	
	return movies.stream().flatMap(movie -> movie.getBoxarts().stream())
			.reduce(KatasUtils::largestBoxArt).map(BoxArt::getUrl).orElse("");}
}
