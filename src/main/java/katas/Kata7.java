package katas;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";

    public static List<Map> execute() {

	List<MovieList> movieLists = DataUtil.getMovieLists();

	return movieLists.stream().map(MovieList::getVideos).flatMap(List::stream).map(movieInternal -> {
	    Optional<BoxArt> optionalBoxArtMovie = movieInternal.getBoxarts().stream().reduce((boxart1,
		    boxart2) -> (boxart1.getHeight() * boxart1.getWidth() < boxart2.getHeight() * boxart2.getWidth()
			    ? boxart1 : boxart2));
	    return ImmutableMap.of(ID, movieInternal.getId(), TITLE, movieInternal.getTitle(), BOXART,
		    optionalBoxArtMovie.isPresent() ? optionalBoxArtMovie.get().getUrl() : "");

	}).collect(Collectors.toList());

    }
}
