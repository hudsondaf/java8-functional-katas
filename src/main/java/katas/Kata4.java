package katas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String BOXART = "boxart";

    public static List<Map> execute() {

	List<MovieList> movieLists = DataUtil.getMovieLists();

	return movieLists.stream().map(MovieList::getVideos).flatMap(List<Movie>::stream)
				.map(functionVideoToMap())
				.collect(Collectors.toList());
    }
    
    public static Function<Movie, ImmutableMap<String,Object>> functionVideoToMap(){
    	return video -> ImmutableMap.of(ID, video.getId(), TITLE, video.getTitle(),
				BOXART, video.getBoxarts().stream()
		.filter(boxart -> boxart.getWidth() == 150 && boxart.getHeight() == 200).map(BoxArt::getUrl).findFirst().orElse(""));
    }
}

