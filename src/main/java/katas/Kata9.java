package katas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.KatasUtils;
import util.DataUtil;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";
    public static final String TIME = "time";

    public static List<Map> execute() {
	List<MovieList> movieLists = DataUtil.getMovieLists();
	
	return movieLists.stream().flatMap(movieList -> movieList.getVideos().stream()).map(functionMovieToImmutableMap())
			.collect(Collectors.toList());
    }
    
    public static Function<Movie, ImmutableMap<String, Object>> functionMovieToImmutableMap(){
    	return movieInternal -> 

	    ImmutableMap.of(ID, movieInternal.getId(), TITLE, movieInternal.getTitle(), TIME,
	    		movieInternal.getInterestingMoments().get(IntStream.range(0, movieInternal.getInterestingMoments().size())
		    	.filter(n -> n > movieInternal.getInterestingMoments().size() / 2).findFirst().orElse(0)).getTime(),
	    		BOXART, movieInternal.getBoxarts().stream().reduce(KatasUtils::smallestBoxArt)
	    		.map(BoxArt::getUrl).orElse(""));
			
    }
}
