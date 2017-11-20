package katas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
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

	return movieLists.stream().map(MovieList::getVideos).flatMap(List::stream).map(movieInternal -> {
	    Optional<BoxArt> optionalBoxArtMovie = movieInternal.getBoxarts().stream().reduce((boxart1,
		    boxart2) -> (boxart1.getHeight() * boxart1.getWidth() < boxart2.getHeight() * boxart2.getWidth()
			    ? boxart1 : boxart2));
	    OptionalInt optionalIndexInterestingMoment = IntStream
		    .range(0, movieInternal.getInterestingMoments().size())
		    .filter(n -> n > movieInternal.getInterestingMoments().size() / 2).findFirst();

	    return ImmutableMap.of(ID, movieInternal.getId(), TITLE, movieInternal.getTitle(), TIME,
		    movieInternal.getInterestingMoments()
			    .get(optionalIndexInterestingMoment.isPresent() ? optionalIndexInterestingMoment.getAsInt()
				    : 0)
			    .getTime(),
		    BOXART, optionalBoxArtMovie.isPresent() ? optionalBoxArtMovie.get().getUrl() : "");

	}).collect(Collectors.toList());
    }
}
